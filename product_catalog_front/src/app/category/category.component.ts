import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../api.services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  data: any[];
  page = 0;
  size = 2;
  totalItems: number;
  totalPages: number;
  children = false;
  first = 0;
  loading = true;
  idParentCategory = 0;

  constructor(private apiCategory: CategoryService) {
  }

  ngOnInit(): void {
    this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
      this.totalItems = value.totalItems;
      this.totalPages = value.totalPages;
      this.data = value.categoryDtoList;
      this.loading = false;
    });
  }

  changePage($event: any): void {
    this.page = ($event.first / this.size);
    if (!this.children) {
      this.loading = true;
      this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
        this.data = value.categoryDtoList;
        this.loading = false;
      });
    } else {
      this.loading = true;
      this.apiCategory.getChildrenCategory(this.size, this.page, this.idParentCategory).subscribe(value => {
        this.data = value.categoryDtoList;
        this.loading = false;
      });
    }
  }

  nextStep($event: any): void {
    if (!$event.lastLevel) {
      this.page = 0;
      this.data = [];
      this.first = 0;
      this.children = true;
      this.idParentCategory = $event.idCategoryParent;
      this.apiCategory.getChildrenCategory(this.size, this.page, this.idParentCategory).subscribe(value => {
        this.totalItems = value.totalItems;
        this.totalPages = value.totalPages;
        this.data = value.categoryDtoList;
      });
    }
  }
}

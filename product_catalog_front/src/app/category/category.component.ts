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


  constructor(private apiCategory: CategoryService) {
  }

  ngOnInit(): void {
    this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
      this.totalItems = value.totalItems;
      this.totalPages = value.totalPages;
      this.data = value.categoryDtoList;
    });
  }

  changePage($event: any): void {
    this.page = ($event.first / this.size);
    this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
      this.data = value.categoryDtoList;
    });
  }
}

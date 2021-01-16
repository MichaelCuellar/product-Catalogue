import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {CategoryService} from '../api.services/category.service';
import {MenuItem} from 'primeng/api';
import {ProductService} from '../api.services/product.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  data: any[];
  productList: any[];
  page = 0;
  size = 2;
  totalItems: number;
  totalPages: number;
  children = false;
  first = 0;
  loading = true;
  idParentCategory = 0;
  items: MenuItem[] = [];
  home: MenuItem;
  category = true;
  product = false;
  productSelect = false;
  responseProduct: any;
  positionMenu = 0;
  sortOrder: number;
  lastSection: number[] = [];

  constructor(private apiCategory: CategoryService, private ref: ChangeDetectorRef, private apiProduct: ProductService) {
  }

  ngOnInit(): void {
    this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
      this.totalItems = value.totalItems;
      this.totalPages = value.totalPages;
      this.data = value.categoryDtoList;
      this.loading = false;
    });
    this.home = {
      icon: 'pi pi-home', routerLink: '/home', command: () => {
        this.initHome();
      }
    };
  }

  initHome(): void {
    this.loading = true;
    this.children = false;
    this.page = 0;
    this.first = 0;
    this.data = [];
    this.sortOrder = 1;
    this.positionMenu = 0;
    this.lastSection = [];
    this.idParentCategory = 0;
    this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
      this.productList = [];
      this.category = true;
      this.product = false;
      this.productSelect = false;
      this.totalItems = value.totalItems;
      this.totalPages = value.totalPages;
      this.data = value.categoryDtoList;
      this.loading = false;
      this.ref.detectChanges();
    });
  }

  changePage($event: any): void {
    this.page = ($event.first / this.size);
    this.loading = true;
    if (this.category) {
      if (!this.children) {
        this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
          this.data = value.categoryDtoList;
          this.loading = false;
        });
      } else {
        this.apiCategory.getChildrenCategory(this.size, this.page, this.idParentCategory).subscribe(value => {
          this.data = value.categoryDtoList;
          this.loading = false;
        });
      }
    } else {
      this.apiProduct.getProductIndex(this.size, this.page, this.idParentCategory).subscribe(value => {
        this.productList = value.dtoList;
        this.ref.detectChanges();
        this.loading = false;
      });
    }
  }

  nextStep($event: any): void {
    this.lastSection.push(this.idParentCategory);
    if (this.category) {
      this.sortOrder = 1;
      this.loading = true;
      this.positionMenu++;
      this.idParentCategory = $event.idCategoryParent;
      this.page = 0;
      this.data = [];
      this.first = 0;
      if (!$event.lastLevel) {
        this.children = true;
        this.idParentCategory = $event.idCategoryParent;
        this.apiCategory.getChildrenCategory(this.size, this.page, this.idParentCategory).subscribe(value => {
          this.ref.detectChanges();
          this.totalItems = value.totalItems;
          this.totalPages = value.totalPages;
          this.data = value.categoryDtoList;
          this.loading = false;
        });
      } else {
        this.apiProduct.getProductIndex(this.size, this.page, this.idParentCategory).subscribe(value => {
          this.category = false;
          this.product = true;
          this.productList = value.dtoList;
          this.totalItems = value.totalItems;
          this.totalPages = value.totalPages;
          this.ref.detectChanges();
          this.loading = false;
        });
      }
    } else {
      this.apiProduct.getProductById($event).subscribe(value => {
        this.responseProduct = value;
        this.productSelect = true;
        this.category = false;
        this.product = false;
        console.log(value.name + 'Soy un producto');
      });
    }
  }

  backSection(): void {
    this.loading = true;
    this.page = 0;
    this.data = [];
    this.first = 0;
    this.sortOrder = 1;
    const position = this.lastSection.pop();
    this.idParentCategory = position;
    if (position === 0) {
      this.apiCategory.getParentCategory(this.size, this.page).subscribe(value => {
        this.totalItems = value.totalItems;
        this.totalPages = value.totalPages;
        this.data = value.categoryDtoList;
        this.loading = false;
        this.positionMenu = 0;
        this.children = false;
      });
    } else if (this.category || this.product) {
      this.category = true;
      this.product = false;
      this.apiCategory.getChildrenCategory(this.size, this.page, position).subscribe(value => {
        this.data = value.categoryDtoList;
        this.totalItems = value.totalItems;
        this.totalPages = value.totalPages;
        this.loading = false;
      });
    } else {
      this.apiProduct.getProductIndex(this.size, this.page, position).subscribe(value => {
        this.category = false;
        this.product = true;
        this.productSelect = false;
        this.productList = value.dtoList;
        this.totalItems = value.totalItems;
        this.totalPages = value.totalPages;
        this.ref.detectChanges();
        this.loading = false;
      });
    }
  }
}

import {Component, Input, OnInit} from '@angular/core';
import {ProductService} from '../api.services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product: any;
  priceCOP: number;

  constructor(private apiProduct: ProductService) { }

  ngOnInit(): void {
    this.apiProduct.getExchangeRate().subscribe(value => {
      this.priceCOP = this.product.price * value.quotes.USDCOP;
    });
  }

  changeUSDToCOP(price: number): void{
    this.apiProduct.getExchangeRate().subscribe(value => {
      this.priceCOP = price * value.quotes.USDCOP;
      console.log(this.priceCOP);
    });
  }
}

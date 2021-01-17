import {Component, Input, OnInit} from '@angular/core';
import {ProductService} from '../api.services/product.service';
import {CarShopService} from '../api.services/car-shop.service';
import {ProductDTO} from '../commons/domain/productDTO';
import {MessageService} from 'primeng/api';
import {SaleProductDto} from '../commons/domain/saleProductDto';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product: ProductDTO;
  priceCOP: number;
  quantity: any;

  constructor(private apiProduct: ProductService, private apiCarShop: CarShopService,
              private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.apiProduct.getExchangeRate().subscribe(value => {
      this.priceCOP = this.product.price * value.quotes.USDCOP;
    });
  }

  addCarShop(): void {
    // tslint:disable-next-line:triple-equals
    if (this.quantity == 0 || this.quantity == '' || this.quantity == null) {
      this.messageService.add({severity: 'info', summary: 'Info', detail: 'Agregue una cantidad válida o mayor a 0'});
    } else {
      const selectProduct: SaleProductDto = new SaleProductDto();
      selectProduct.idProduct = this.product.idProduct;
      selectProduct.quantity = this.quantity;
      this.apiCarShop.addCarShop(sessionStorage.basic, selectProduct).subscribe(() => {
        this.messageService.add({
          severity: 'info',
          summary: 'Info',
          detail: 'Su orden se ha agregado y/o actualizado en el carrito'
        });
      });
    }
  }
}

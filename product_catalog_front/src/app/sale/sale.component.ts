import {Component, OnInit} from '@angular/core';
import {CarShopService} from '../api.services/car-shop.service';
import {CarShopDto} from '../commons/domain/carShopDto';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {
  carShop: CarShopDto[] = [];
  tittle = 'Su carro se encuentra vacio';

  constructor(private apiCarShop: CarShopService) {
  }

  ngOnInit(): void {
    this.apiCarShop.getCarShop(sessionStorage.basic).subscribe(value => {
      this.carShop = value;
    });
  }

  sumAll(): number {
    let sum = 0;
    if (this.carShop == null) {
      return sum;
    }
    this.carShop.forEach(value => {
      sum = sum + (value.productDto.price * value.quantity);
    });
    return sum;
  }

  deleteCarShop(): void {
    this.apiCarShop.deleteCarShop(this.carShop[0].idCarShop).subscribe(() => {
      this.tittle = 'Su compra se ha cancelado';
      this.carShop = [];
    });
  }

}

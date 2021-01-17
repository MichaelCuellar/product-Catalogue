import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SaleProductDto} from '../commons/domain/saleProductDto';

@Injectable({
  providedIn: 'root'
})
export class CarShopService {

  url: string = environment.url_Base;

  constructor(private http: HttpClient) {
  }

  getCarShop(basic: string): Observable<any> {
    const options = {
      headers: new HttpHeaders().append('basic', basic)
    };
    return this.http.get(this.url + '/carShop', options);
  }

  addCarShop(basic: string, addCarShopDto: SaleProductDto): Observable<any> {
    const options = {
      headers: new HttpHeaders().append('basic', basic)
    };
    return this.http.post(this.url + '/addCarShop', addCarShopDto, options);
  }

  deleteCarShop(id: number): Observable<any> {
    return this.http.delete(this.url + '/delete/' + id);
  }
}

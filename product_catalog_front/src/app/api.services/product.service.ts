import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url: string = environment.url_Base;

  constructor(private http: HttpClient) {
  }

  getProductIndex(size: number, page: number, idCategory: number): Observable<any> {
    return this.http.get(`${this.url}/product/${idCategory}/${size}/${page}`);
  }

  getProductById(idProduct: number): Observable<any> {
    return this.http.get(`${this.url}/product/${idProduct}`);
  }

  getExchangeRate(): Observable<any> {
    return this.http.get('http://api.currencylayer.com/live?access_key=4de19ef85ee8d76045d576862fb74c85&%20currencies=COP&format=1');
  }
}

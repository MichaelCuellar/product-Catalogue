import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url: string = environment.url_Base;

  constructor(private http: HttpClient) {
  }

  getParentCategory(size: number, page: number): Observable<any> {
    return this.http.get(`${this.url}/parent/${size}/${page}`);
  }
}

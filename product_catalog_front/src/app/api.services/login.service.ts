import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url: string = environment.url_Base;

  constructor(private http: HttpClient) {
  }

  handleError(error: HttpErrorResponse): any {
    let errorMessage = 'Unknown error!';
    console.log(error);
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else if (error.status === 401) {
      errorMessage = 'Contraseña y/o usuario incorrecto, intente nuevamente';
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  getLogin(basic: string): Observable<any> {
    const options = {
      headers: new HttpHeaders().append('basic', basic)
    };
    return this.http.get(this.url + '/login', options).pipe(catchError(this.handleError));
  }
}

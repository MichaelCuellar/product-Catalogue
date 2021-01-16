import { Component, OnInit } from '@angular/core';
import {LoginService} from '../api.services/login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'tienda-harry';
  userID: number;
  password: string;

  constructor(private apiService: LoginService, private route: Router) {
  }

  ngOnInit(): void {
  }

  login(): void {
    const user: string = this.userID + ':' + this.password;
    const encodedSer = btoa(user);
    this.apiService.getLogin(encodedSer).subscribe( value => {
      console.log(value);
      if (value){
       this.route.navigate(['home']).then( () => {
          sessionStorage.basic = encodedSer;
        });
      }
    });
  }
}

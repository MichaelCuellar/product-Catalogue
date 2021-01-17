import {Component, OnInit} from '@angular/core';
import {LoginService} from '../api.services/login.service';
import {Router} from '@angular/router';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'tienda-harry';
  userID: number;
  password: string;
  passwordAdmin: number;
  userAdmin: any;
  isAdmin = false;

  constructor(private apiService: LoginService, private route: Router , private messageService: MessageService) {
  }

  ngOnInit(): void {
  }

  login(): void {
    const user: string = this.userID + ':' + this.password;
    const encodedSer = btoa(user);
    this.apiService.getLogin(encodedSer).subscribe(value => {
      if (value.status) {
        sessionStorage.basic = encodedSer;
        if (value.role.idRole === 1) {
          this.userAdmin = value.name;
          this.openDialog();
        } else {
          this.route.navigate(['home']).then(() => {
          });
        }
      }
    }, (error => {
      this.messageService.add({severity: 'info', summary: 'Info', detail: error});
    }));
  }

  openDialog(): void {
    this.isAdmin = true;
  }

  closeDialog(): void {
    this.isAdmin = false;
  }

  loginAdmin(): void {
    const code = this.passwordAdmin;
    this.apiService.getLoginAdmin(sessionStorage.basic, code).subscribe(value => {
      if (value.status) {
        this.route.navigate(['home']).then(() => {
        });
      }
    }, (error => {
      this.messageService.add({severity: 'info', summary: 'Info', detail: 'Codigo invalido intente nuevamente'});
    }));
  }
}

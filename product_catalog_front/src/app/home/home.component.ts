import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  boutique = true;
  display = false;


  constructor(private route: Router) {
  }

  ngOnInit(): void {
  }


  shoppingCart(): void {
    this.boutique = false;
  }

  closeSession(): void {
    this.route.navigate(['']).then( () => {
      sessionStorage.clear();
    });
  }

  changePage($event: any): void {
    console.log($event);
  }
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule} from "@angular/forms";
import {PanelModule} from 'primeng/panel';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule } from '@angular/common/http';
import { LoginService } from './api.services/login.service';
import { LoginComponent } from './login/login.component';
import {TableModule} from 'primeng/table';
import {CardModule} from 'primeng/card';
import {InputNumberModule} from 'primeng/inputnumber';
import { HomeComponent } from './home/home.component';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {ConfirmationService} from 'primeng/api';
import {DialogModule} from 'primeng/dialog';
import {ToastModule} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {DataViewModule} from 'primeng/dataview';
import {CategoryService} from './api.services/category.service';
import { CategoryComponent } from './category/category.component'


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    PanelModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TableModule,
    CardModule,
    InputNumberModule,
    MessagesModule,
    MessageModule,
    ConfirmDialogModule,
    DialogModule,
    ToastModule,
    DataViewModule
  ],
  providers: [LoginService,ConfirmationService,MessageService,CategoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }

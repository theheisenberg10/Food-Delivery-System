import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { HomePageComponent } from './home-page/home-page.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MyServService} from './my-serv.service';
import { AddRestComponent } from './add-rest/add-rest.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    HomePageComponent,
    AddRestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [MyServService],
  bootstrap: [AppComponent]
})
export class AppModule { }

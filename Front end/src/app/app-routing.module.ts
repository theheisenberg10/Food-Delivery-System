import { NgModule } from '@angular/core';
import {SignupComponent} from './signup/signup.component';
import {AddRestComponent} from './add-rest/add-rest.component';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
{path :"",component:SignupComponent},
{path :"addRest",component:AddRestComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

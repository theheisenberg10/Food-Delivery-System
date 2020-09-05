import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';

export class User{
constructor(
  public mob_no : string,
  public pass :string,
  public name :string,
  public area :string,
  public cart : FoodCart
 
){}

}

export class Restaurant{
constructor(
  public id : number,
  public pass :string,
  public name :string,
  public area :string,
  public type : string,
  public foodies : number,
  public items : any
 
){}

}

export class Dish{
constructor(
  public id : number,
  public name : string,
  public price : number,
  public cuisine : string,
  public popularity : string,
  public rest: Restaurant
 
){}

}



export class FoodCart{
constructor(
  public cart_id : number,
  public mp : any ,
  public coupon_code :string,
  public bill_amount : number,
  public user : User
 
){}

}









@Injectable({
  providedIn: 'root'
})
export class MyServService {

  constructor(
     private httpClient:HttpClient
  ) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      
    })
    
  }


public SignUp(user):Observable<User>{

  console.log(user); //2nd

  return this.httpClient.post<User>(`http://localhost:1234/createNewUser`,JSON.stringify(user), this.httpOptions); 
}

public addRest(rest):Observable<Restaurant>{

  console.log(rest); //2nd

  return this.httpClient.post<Restaurant>(`http://localhost:1234/addRestaurant`,JSON.stringify(rest), this.httpOptions); 
}


}

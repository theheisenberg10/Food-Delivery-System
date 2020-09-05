import { Component, OnInit } from '@angular/core';
import {MyServService,User} from '../my-serv.service';
import { Router } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  addForm: FormGroup;
  submitted: boolean=false;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private service : MyServService) { }

  ngOnInit(): void {
    this.addForm=this.formBuilder.group({
      mob_no: ['', [Validators.required, Validators.pattern("[1-9][0-9]{9}")]],
      pass: ['', [Validators.required, Validators.pattern("")]],
      name: ['', [Validators.required, Validators.pattern("[a-z]{2,14}")]],
      area:['',[Validators.required,Validators.pattern("[a-z]{2,20}")]]
    });



  }




  signUp(){
    this.submitted = true;
    if (this.addForm.invalid) {
      alert(`something is not right`);
      return;
    }
    console.log(this.addForm.value);
    this.service.SignUp(this.addForm.value).subscribe(data => {
    alert(`user named ${this.addForm.controls.name.value} added successfully..!`);
    })
  }



}

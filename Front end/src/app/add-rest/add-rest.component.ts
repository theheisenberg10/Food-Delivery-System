import { Component, OnInit } from '@angular/core';
import {MyServService,User,Restaurant} from '../my-serv.service';
import { Router } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-rest',
  templateUrl: './add-rest.component.html',
  styleUrls: ['./add-rest.component.css']
})
export class AddRestComponent implements OnInit {

  addForm: FormGroup;
  submitted: boolean=false;
  rest:Restaurant;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private service : MyServService
    
    ) { }

  ngOnInit(): void {
    this.addForm=this.formBuilder.group({
      type: ['', [Validators.required, Validators.pattern("")]],
      pass: ['', [Validators.required, Validators.pattern("")]],
      name: ['', [Validators.required, Validators.pattern("[a-z]{2,14}")]],
      area:['',[Validators.required,Validators.pattern("[a-z]{2,20}")]]
    });

  }


  addRest(){
    this.submitted = true;
    if (this.addForm.invalid) {
      alert(`something is not right`);
      return;
    }
    console.log(this.addForm.value);
    


    this.service.addRest(this.addForm.value).subscribe(data => {
    alert(`${this.addForm.controls.name.value} Restaurant added successfully..!`);
    })
  }

}

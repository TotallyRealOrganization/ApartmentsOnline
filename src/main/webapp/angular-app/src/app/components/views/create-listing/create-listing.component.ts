import { Component, OnInit } from '@angular/core';
import { Validators, FormControl } from '@angular/forms';

import { Apartment } from '../../../models/Apartment'

@Component({
  selector: 'app-create-listing',
  templateUrl: './create-listing.component.html',
  styleUrls: ['./create-listing.component.css']
})
export class CreateListingComponent implements OnInit {
  apt: Apartment
  email = new FormControl('', [Validators.required])
  
  getErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
        this.email.hasError('email') ? 'Not a valid email' :
            '';
  }

  constructor() {  } 

  ngOnInit(): void {

  }


  onSubmit(): void {
  
  }

}



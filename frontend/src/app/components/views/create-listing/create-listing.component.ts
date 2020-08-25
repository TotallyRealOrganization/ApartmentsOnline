import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { Apartment } from '../../../models/Apartment'

@Component({
  selector: 'app-create-listing',
  templateUrl: './create-listing.component.html',
  styleUrls: ['./create-listing.component.css']
})
export class CreateListingComponent implements OnInit {

  aptForm: FormGroup

  ngOnInit(): void {
    this.aptForm = new FormGroup({
      address: new FormControl('', [Validators.required]),
      numBeds: new FormControl('', [Validators.required]),
      numBaths: new FormControl('', [Validators.required]),
      area: new FormControl('', [Validators.required]),
      imgURL: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      utilDetails: new FormControl('', [Validators.required]),
      restrictions: new FormControl('', [Validators.required]),
    })
  }


  onSubmit(): void {
    console.log('a')
  }

}



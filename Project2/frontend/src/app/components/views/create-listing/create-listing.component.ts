import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Apartment } from '../../../models/Apartment'
import { ApartmentService } from '../../../services/apartment.service'
import { CookieService } from 'ngx-cookie-service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-listing',
  templateUrl: './create-listing.component.html',
  styleUrls: ['./create-listing.component.css']
})
export class CreateListingComponent implements OnInit {

  aptForm: FormGroup
  
  constructor(private apartmentService: ApartmentService, private router: Router, private cookieService: CookieService, private userService: UserService) { }
  
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
    const id = this.cookieService.get('userID')
    const a = this.aptForm.controls.address.value
    const beds = this.aptForm.controls.numBeds.value
    const baths = this.aptForm.controls.numBaths.value
    const area = this.aptForm.controls.area.value
    const img = this.aptForm.controls.imgURL.value
    const price = this.aptForm.controls.price.value
    const util = this.aptForm.controls.utilDetails.value
    const restr = this.aptForm.controls.restrictions.value

    const apartment: Apartment = new Apartment(id,beds,baths,a,area,img,price,util,restr)
    this.apartmentService.postApartment(apartment).subscribe(e => {
      this.userService.fetchUser(this.cookieService.get('userID')).subscribe(u => {
        console.log(u)
      })
      this.router.navigate(['/home'])
    })
  }

}



import { Component, OnInit } from '@angular/core';
import { Apartment } from 'src/app/models/Apartment';
import { ApartmentService } from 'src/app/services/apartment.service';

@Component({
  selector: 'app-all-listings',
  templateUrl: './all-listings.component.html',
  styleUrls: ['./all-listings.component.css']
})
export class AllListingsComponent implements OnInit {
  apartments: Apartment[]

  constructor(private apService: ApartmentService) {
    apService.getAllApartments().subscribe(e => {
      this.apartments = e
      console.log(e)
    })
  }

  ngOnInit(): void {
  }

}

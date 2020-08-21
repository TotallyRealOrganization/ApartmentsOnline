import { Component, OnInit, Input } from '@angular/core';
import { Amenities } from '../../../models/Amenties'

@Component({
  selector: 'app-amenities',
  templateUrl: './amenities.component.html',
  styleUrls: ['./amenities.component.css']
})
export class AmenitiesComponent implements OnInit {
  @Input() amenities: Amenities;

  constructor() { }

  ngOnInit(): void {
  }

}

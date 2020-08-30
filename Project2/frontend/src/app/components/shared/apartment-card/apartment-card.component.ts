import { Component, OnInit, Input } from '@angular/core';
import { Apartment } from 'src/app/models/Apartment';

@Component({
  selector: 'app-apartment-card',
  templateUrl: './apartment-card.component.html',
  styleUrls: ['./apartment-card.component.css']
})
export class ApartmentCardComponent implements OnInit {

  @Input() apartment: Apartment

  constructor() { }

  ngOnInit(): void {
  }

}

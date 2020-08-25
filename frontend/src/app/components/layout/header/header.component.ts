import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  login = "/login";
  createListing = "/create-listing";
  home = "";
  aboutUs = "";
  postedApartments = "/posted-apartments";
  savedApartments = "/saved-apartments";
  allListings = "/all-listings";
  register="/register";

  constructor() { }

  ngOnInit(): void {
  }

}

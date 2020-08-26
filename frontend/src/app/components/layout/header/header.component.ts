import { Component, OnInit, Input } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

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

  loggedIn: boolean = false
  loggedOut: boolean = true

  constructor(private userService: UserService) {
    userService.loggedIn.subscribe(e => {
      this.loggedIn = e
      this.loggedOut = !e
    })
  }

  ngOnInit(): void {
  }

}

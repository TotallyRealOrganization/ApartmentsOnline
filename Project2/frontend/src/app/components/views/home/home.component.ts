import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../../../services/user.service'
import { User } from 'src/app/models/User';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: User
  

  createListing = "/create-listing";
  postedApartments = "/posted-apartments";
  savedApartments = "/saved-apartments";
  allListings = "/all-listings";

  constructor(private router: Router, private userService: UserService, private cookieService: CookieService,) {
    this.user = userService.getUser()
    if (!this.user) {
      this.router.navigate(['/login'])
    }
  }

  ngOnInit(): void {
  }

  logout() {
    console.log('clicked')
    this.cookieService.delete('userID')
    window.location.reload()
  }

}

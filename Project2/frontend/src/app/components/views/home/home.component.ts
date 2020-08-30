import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../../../services/user.service'
import { User } from 'src/app/models/User';

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

  constructor(private router: Router, private userService: UserService) {
    this.user = userService.getUser()
    if (!this.user) {
      this.router.navigate(['/login'])
    }
  }

  ngOnInit(): void {
  }

  logout() {
    console.log('logout')
  }

}
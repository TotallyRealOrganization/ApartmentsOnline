import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { Apartment } from 'src/app/models/Apartment';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-posted-apartments',
  templateUrl: './posted-apartments.component.html',
  styleUrls: ['./posted-apartments.component.css']
})
export class PostedApartmentsComponent implements OnInit {

  user: User
  apartments: Apartment[]

  constructor(private userService: UserService) {
    this.user = userService.getUser()
    if (this.user) {
      this.apartments = this.user.listedApartments
    }
  }

  ngOnInit(): void {
  }

}

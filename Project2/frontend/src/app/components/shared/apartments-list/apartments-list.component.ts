import { Component, OnInit, Input } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';
import { Apartment } from 'src/app/models/Apartment';

@Component({
  selector: 'app-apartments-list',
  templateUrl: './apartments-list.component.html',
  styleUrls: ['./apartments-list.component.css']
})
export class ApartmentsListComponent implements OnInit {
  
  @Input() apartments: Apartment[]
  user: User

  constructor() {
  }

  ngOnInit(): void {
  }

}

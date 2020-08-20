import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input()username:string = "";
  @Input() password:string = "";

  constructor() { }

  ngOnInit(): void {
  }

  getUsername(evt: any): void {
    this.username = evt.target.value
  }

  getPassword(evt: any): void {
    this.password = evt.target.value
  }
}

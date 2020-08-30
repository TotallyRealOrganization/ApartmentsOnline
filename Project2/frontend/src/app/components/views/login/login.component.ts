import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../../services/user.service'
import { User } from 'src/app/models/User';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  cookieExists: boolean
  userID: string

  constructor(private userService: UserService, private router: Router, private cookieService: CookieService) {
    this.cookieExists = cookieService.check('userID')
    if (this.cookieExists) {
      this.userID = cookieService.get('userID')
      this.userService.fetchUser(this.userID).subscribe(e => {
        this.router.navigate(['/home'])
      })
    }
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
    })
  }
  
  onSubmit(): void {
    const e = this.loginForm.controls.email.value
    const p = this.loginForm.controls.password.value

    const u: User = new User(e, p)

    this.userService.login(u).subscribe(e => {
      console.log(e)
      this.router.navigate(['/home'])
    })
  }

}

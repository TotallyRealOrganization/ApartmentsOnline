import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UserService } from '../../../services/user.service'
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
      fullName: new FormControl('', [Validators.required]),
    })
  }
  
  onSubmit(): void {
    const e = this.registerForm.controls.email.value
    const p = this.registerForm.controls.password.value
    const fName = this.registerForm.controls.fullName.value
    
    const u: User = new User(e, p, fName)
    
    this.userService.register(u).subscribe(e => {
      console.log(e)
      this.router.navigate(['/home'])
    })
  }

}

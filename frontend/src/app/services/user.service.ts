import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User';

const apiUrl: string = window.location.protocol + "//" + window.location.host + window.location.pathname + "api";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(u: string, p: string): void {
    console.log(`logging in for ${u} with ${p}`)
    // return this.http.post<User>(`${apiUrl}/user/login`, {username: u, password: p})
  }
  
  register(user: User ): void {
    console.log('registering')
    console.log(user)
    // return this.http.post<boolean>(`${apiUrl}/user/register`, user)
  }

}

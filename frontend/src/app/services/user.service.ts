import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User';

const apiUrl: string = window.location.protocol + "//" + window.location.host + window.location.pathname + "api";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: User

  constructor(private http: HttpClient) { }

  login(u: string, p: string): Observable<User> {
    console.log(`logging in for ${u} with ${p}`)
    return this.http.post<User>(`${apiUrl}/user/login`, {username: u, password: p})
  }
  
  register(u: User ): Observable<User> {
    console.log('registering')
    console.log(u)
    let usr = this.http.post<User>(`${apiUrl}/user/register`, u)
    usr.subscribe(e => {
      this.user = e
      console.log(this.user)
    })
    return usr
  }

}

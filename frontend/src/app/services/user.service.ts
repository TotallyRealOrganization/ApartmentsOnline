import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { share } from 'rxjs/operators';

// const apiUrl: string = window.location.protocol + "//" + window.location.host + window.location.pathname + "api";
const apiUrl: string = window.location.protocol + '//localhost:8080/api'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: User

  constructor(private http: HttpClient) { }

  login(u: User): Observable<User> {
    let usr = this.http.post<User>(`${apiUrl}/user/login`, u).pipe(share())
    usr.subscribe(e => {
      this.user = e
    })
    return usr
  }
  
  register(u: User ): Observable<User> {
    let usr = this.http.post<User>(`${apiUrl}/user/register`, u).pipe(share())
    usr.subscribe(e => {
      this.user = e
    })
    return usr
  }

  getUser(): User {
    return this.user
  }

}

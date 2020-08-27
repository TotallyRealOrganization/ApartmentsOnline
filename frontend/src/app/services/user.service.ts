import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { User } from '../models/User';
import { share } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';

// const apiUrl: string = window.location.protocol + "//" + window.location.host + window.location.pathname + "api";
const apiUrl: string = window.location.protocol + '//localhost:8080/api'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: User
  loggedIn: Subject<boolean> = new Subject<boolean>()

  constructor(private http: HttpClient, private cookieService: CookieService) { }

  login(u: User): Observable<User> {
    let usr = this.http.post<User>(`${apiUrl}/user/login`, u).pipe(share())
    usr.subscribe(e => {
      this.user = e
      this.cookieService.set('userID', e.id)
      this.loggedIn.next(true)
    })
    return usr
  }
  
  register(u: User ): Observable<User> {
    let usr = this.http.post<User>(`${apiUrl}/user/register`, u).pipe(share())
    usr.subscribe(e => {
      this.user = e
      this.cookieService.set('userID', e.id)
      this.loggedIn.next(true)
    })
    return usr
  }

  getUser(): User {
    console.log(this.user)
    return this.user
  }

  fetchUser(userID: string): Observable<User> {
    let usr = this.http.get<User>(`${apiUrl}/user/${userID}`).pipe(share())
    usr.subscribe(e => {
      this.user = e
      this.loggedIn.next(true)
    })
    return usr
  }

}

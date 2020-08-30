import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Apartment } from '../models/Apartment';
import { share } from 'rxjs/operators';
import { UserService } from './user.service';

const apiUrl: string = window.location.protocol + '//localhost:8080/api'

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {

  constructor(private http: HttpClient, private cookieService: CookieService,private userService: UserService) { }

  postApartment(a: Apartment): Observable<Apartment> {
    let apt = this.http.post<Apartment>(`${apiUrl}/apartment`, a).pipe(share())
    apt.subscribe(e => {
      this.userService.fetchUser(this.cookieService.get('userID')).subscribe(u => {
        console.log(u)
      })
    })
    return apt
  }
}

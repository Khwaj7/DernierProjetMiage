import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Membre } from '../model/membre';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class MembreService {
	private usersUrl: string;
 
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://127.0.0.1:8080/members';
  }
 
  public findAll(): Observable<Membre[]> {
    return this.http.get<Membre[]>(this.usersUrl);
  }
 
  public save(user: Membre) {
    return this.http.post<Membre>(this.usersUrl, user);
  }
}

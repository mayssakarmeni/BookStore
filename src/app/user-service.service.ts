import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { Observable } from 'rxjs/Observable';
import { catchError } from 'rxjs/operators';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  uri = 'http://localhost:8080/PracticalExerciceSpringMVC2/user';
  constructor(private http: HttpClient) { }
  getAllUsers(data): Observable<any> {
    return this.http.get(`${this.uri}/getAllUsers`, data)
      .pipe(
        tap((resultat) => console.log("Résultat de la requête : ",resultat)),
        catchError(this.handleError)
      );
  }
  handleError(error: HttpErrorResponse){
    console.log("errror");
    return throwError(error); 
    }
    deleteUser(idUser) {
      return this.http.delete(`${this.uri}/deleteuser/${idUser}`,{responseType: 'text'});
     

    } 
}

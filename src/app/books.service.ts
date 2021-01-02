import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders , HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { tap } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import Book from './Book';
const optionRequete = {
  headers: new HttpHeaders({ 
   
    'mon-entete-personnalise':'maValeur'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  [x: string]: any;
  
  uri = 'http://localhost:8080/PracticalExerciceSpringMVC2/book';
  
  

  constructor(private http: HttpClient) { }
  addBook(book:Book) {
    
 
    this.http.post(`${this.uri}/addbook`, book,{responseType: 'text'}).subscribe(res => console.log('Done'));
  }
 
  public baseurl = 'http://localhost:8080/PracticalExerciceSpringMVC2/book/getAll';
  userAPI(data): Observable<any> {
    return this.http.get(this.baseurl, data)
      .pipe(
        tap((resultat) => console.log("Résultat de la requête : ",resultat)),
        catchError(this.handleError)
      );
  }
  handleError(error: HttpErrorResponse){
    console.log("errror");
    return throwError(error); 
    }

    
    deletebook(idBook) {
      return this.http.delete(`${this.uri}/deletebook/${idBook}`,{responseType: 'text'});
     

    } 
   
    updateBook( idBook: number,  title:string,  author:string,price:number, releaseDate:Date){
      console.log('update service');
      let book: Book = new Book(idBook,title, author, price,releaseDate );
      console.log(book);
      return this.http.post(`${this.uri}/updatebook`,book,{responseType: 'text'});
      
    }
  
    
    getBookbyID(idBook :number ):Observable<Book>{
      return this.http.get(`${this.uri}/getbook/${idBook}`);
    }
  
    getline(data): Observable<any> {
      return this.http.get(this.baseurli, data)
        .pipe(
          tap((resultat) => console.log("Résultat de la requête : ",resultat)),
          catchError(this.handleError)
        );
    }
   
    }
    
  

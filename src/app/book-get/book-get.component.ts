import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import Book from '../Book';
import { BookpanierService } from '../bookpanier.service';
import { BooksService } from '../books.service';
@Component({
  selector: 'app-book-get',
  templateUrl: './book-get.component.html',
  styleUrls: ['./book-get.component.css']
})
export class BookGetComponent implements OnInit {
Book:Book[];
  books: Array<any>;
  angForm: any;
  book: any;
idBook :number=0;

  constructor(private bs: BooksService ,private route:ActivatedRoute, private cs:BookpanierService) { }

  ngOnInit() {
    this.idBook=this.route.snapshot.params['idBook'];

    this.bs.userAPI(DataTransferItemList).subscribe(data  => {
      this.books = data;
    });

}
deletebook(idBook) {
  this.bs.deletebook(idBook).subscribe(res => {
  
    
      this.books.splice(idBook, 1);
      this.bs.userAPI(DataTransferItemList).subscribe(data => {
        this.books = data;
      });
    });
  }



      getBookbyID(idBook ){
        this.idBook=this.route.snapshot.params['idBook'];
        this.bs.getBookbyID(idBook).subscribe(book => {
            this.book = book;
        })
    
     
  }
  addToCart(idBook: number,quantity: number): void {
    this.bs.getBookbyID(idBook).subscribe(book => {
        this.cs.add(book,quantity);
    });
  }

}

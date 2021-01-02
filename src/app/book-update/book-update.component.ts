import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Book from '../Book';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.css']
})
export class BookUpdateComponent implements OnInit {
  d!: Date;
 books: Book[]=[];
  Book: Book;
  book: Book = {
    idBook: 5 ,title: "", author: "", price: 5, releaseDate: new Date()
};


  constructor(private route: ActivatedRoute, private bookService: BooksService) { }

  ngOnInit(): void {
      this.route.params.subscribe(params => {
          this.bookService.getBookbyID(params.idBook).subscribe(book => {
            this.book = book;
          })
      })
  }

  updateBook(idBook: number, title: string, author: string,price: number, releaseDate: Date ): void {
    console.log(this.book);
    this.bookService.updateBook(idBook,title,author,price,releaseDate).subscribe((book) => {
        console.log('Book added from add-book.component.ts',book);
    })
  }
}
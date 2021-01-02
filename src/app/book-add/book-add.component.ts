import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Book from '../Book';
import { BooksService } from '../books.service';


@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent implements OnInit {

 public angForm: FormGroup;
 bo= new Book;
  constructor(private fb: FormBuilder, private bs: BooksService) {
  this.createForm();
  }
  createForm() {
  this.angForm = this.fb.group({
    title: ['', Validators.required ],
    author: ['', Validators.required ],
    price: ['', Validators.required ],
    releaseDate: ['', Validators.required ]
  });
  }
  addBook() {
  this.bo.author=this.angForm.get('author')?.value
  this.bo.title=this.angForm.get('title')?.value
  this.bo.price=this.angForm.get('price')?.value
  this.bo.releaseDate=this.angForm.get('releaseDate')?.value
    this.bs.addBook(this.bo );
    }
   
  ngOnInit() {
  }
}

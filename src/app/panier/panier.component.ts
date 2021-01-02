import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Book from '../Book';
import { BookpanierService } from '../bookpanier.service';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {
  books: Book[];
  quantities: number[];
  total = 0;

  constructor(private cartService: BookpanierService) { 
    
  }

  ngOnInit(): void {
    console.log(localStorage.getItem('books'));
    this.books = this.cartService.getAllBooks();
    this.quantities = this.cartService.getAllQuantities();

    if(this.books != null){
        for(let i=0; i<this.books.length; i++) {
            this.cartService.calculate(this.books[i].idBook, this.quantities[i]).subscribe(res => {
                this.total += res;
            });
        }
    }
    console.log(this.books);
  }

  purchase() {
      this.cartService.purchase();
  }

  delete(idBook: number): void {
    
    localStorage.removeItem('books');
    
    this.books = this.books.filter(book => {
        return book.idBook != idBook
    })  
    localStorage.setItem('books',JSON.stringify(this.books));
   

    this.cartService.remove(idBook);
    this.books = this.cartService.getAllBooks();

}


}
 /* books!: Array<Book>;
  booksRecieved!: Array<Book>;
  cartBooks: any;
  book : Book =new Book;
  idBook :number=0;
  total : number= 10 ;
  constructor(private router: Router, private bs: BooksService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.idBook=this.route.snapshot.params['idBook'];
    this.bs.getBookbyID(this.idBook).subscribe((data :Book)=>this.book=data)
  }

calclate( ){
  this.total= this.book.price *10
this.bs.calculate( this.total).subscribe((data :number)=>this.total=data)
}
*/
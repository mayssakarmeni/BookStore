import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SlimLoadingBarModule } from 'ng2-slim-loading-bar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookAddComponent } from './book-add/book-add.component';
import { BookGetComponent } from './book-get/book-get.component';
import { BookUpdateComponent } from './book-update/book-update.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BooksService } from './books.service';
import { PanierComponent } from './panier/panier.component';
import { ToasterComponent } from './toaster/toaster.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { UserAddComponent } from './user/user-add/user-add.component';
import { UserGetAllComponent } from './user/user-get-all/user-get-all.component';
import { CommonModule } from '@angular/common';





@NgModule({
  declarations: [
    AppComponent,
    BookAddComponent,
    BookGetComponent,
    BookUpdateComponent,
    PanierComponent,
    ToasterComponent,
    UserAddComponent,
     UserGetAllComponent,


   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlimLoadingBarModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    CommonModule
  
    


  ],
  providers: [BooksService],
  bootstrap: [AppComponent]
})
export class AppModule { }

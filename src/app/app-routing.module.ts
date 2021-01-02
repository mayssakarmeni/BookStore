import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BookAddComponent } from './book-add/book-add.component';
import { BookGetComponent } from './book-get/book-get.component';
import { BookUpdateComponent } from './book-update/book-update.component';
import { PanierComponent } from './panier/panier.component';
import { UserGetAllComponent } from './user/user-get-all/user-get-all.component';


const routes: Routes = [
  {
   
    
      path: 'Book/create',
      component: BookAddComponent
      },
      {
        path: 'Books',
        component: BookGetComponent
        },
        {
          path: 'Book/update/:idBook',
          component: BookUpdateComponent
          },
          {
            path: 'panier',
            component: PanierComponent
            },
            {
              path: 'allUsers',
              component: UserGetAllComponent
              }
            
              
            
          
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

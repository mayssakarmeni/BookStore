import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-user-get-all',
  templateUrl: './user-get-all.component.html',
  styleUrls: ['./user-get-all.component.css']
})
export class UserGetAllComponent implements OnInit {
  Users: Array<any>;
  constructor(private us:UserServiceService,private route:ActivatedRoute) { }

  ngOnInit(): void {
   

    this.us.getAllUsers(DataTransferItemList).subscribe(data  => {
      this.Users = data;
    });
  }
  deleteUser(idUser) {
    this.us.deleteUser(idUser).subscribe(res => {
    
      
        this.Users.splice(idUser, 1);
        this.us.getAllUsers(DataTransferItemList).subscribe(data => {
          this.Users = data;
        });
      });
    }
}

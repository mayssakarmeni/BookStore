import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-toaster',
  templateUrl: './toaster.component.html',
  styleUrls: ['./toaster.component.css']
})
export class ToasterComponent implements OnInit {
  notifyService: any;

  constructor(private toastr: ToastrService) { }

  ngOnInit(): void {
  }

showHtmlToaster(){
	this.notifyService.showHTMLMessage("<h2>Data shown successfully !!</h2>", "Notification")
}
showSuccessWithTimeout(message:any, title:any){
	this.toastr.success("<h2>Data shown successfully !!</h2>", "Notification"
	
)
}
}

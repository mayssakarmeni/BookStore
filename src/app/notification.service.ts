import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private toastr: ToastrService) { }
  showSuccess(message:any, title:any){
    this.toastr.success(message, title)
}
showHTMLMessage(message:any, title:any){
	this.toastr.success(message, title, {
		enableHtml :  true
	})
}
showSuccessWithTimeout(message:any, title:any){
	this.toastr.success(message, title 
	
)
}
}

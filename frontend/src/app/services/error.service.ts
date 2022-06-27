import { Injectable } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ErrorService {

  constructor() { }

  public log(msg: string): void {
    console.error(`An error occurred:  '` + msg +`'!`)
  }

  public alertMessage(msg: string): void {
    this.log(msg);
    alert(msg);
  }

  public alertResponse(response: HttpErrorResponse): Promise<any> {
    const error = response.error;
    if (response.error.message) {
      this.alertMessage(error.message);
    } else {
      this.alertMessage(response.message);
    }

    throw error;
  }
}

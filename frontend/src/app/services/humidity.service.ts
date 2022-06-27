import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {environment} from "../../environments/environment";
import {Humidity} from "../models/humidity";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HumidityService {

  private readonly url = environment.SERVICE_URL + '/api/v1/humidity';

  constructor(private http: HttpClient) { }

  calculateHumidityValues(humidity: Humidity): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const body = JSON.stringify(humidity);
    return this.http.post(this.url, body, { headers, responseType: 'text'});
  }
}

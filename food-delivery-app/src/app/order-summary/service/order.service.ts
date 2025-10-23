import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { API_URL_Order } from 'src/app/constants/url'; 

@Injectable({
  providedIn: 'root'
})

export class OrderService {

  private apiUrl = API_URL_Order+'/order/saveOrder';

  constructor(private http: HttpClient) { }

  saveOrder(data: any):Observable<any>  {
    return this.http.post<any>(this.apiUrl, data);
  }

  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(() => error.message || error);
  }

}
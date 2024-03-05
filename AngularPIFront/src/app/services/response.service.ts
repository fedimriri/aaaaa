import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Response } from '../core/Response';
  
@Injectable({
  providedIn: 'root'
})
export class ResponseService {

  private baseUrl = 'http://localhost:8081/api/response';
  constructor(private http: HttpClient) {}

  createResponse(response: Response): Observable<Response> {
    return this.http.post<Response>(this.baseUrl, response);
  }

}

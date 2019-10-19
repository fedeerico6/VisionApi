import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private url = "localhost:8080/apiVision/getRequest"


  constructor(private http : HttpClient) { }

  sendRequest(file : File) : Promise<any>{
    const httpOptions = {
      headers : new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    };
    return this.http.post(this.url, file, httpOptions).toPromise();
  }
}

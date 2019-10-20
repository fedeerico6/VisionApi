import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ImageSend } from '../models/image-send';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private url = "http://localhost:8080/apiVision/getRequest"


  constructor(private http : HttpClient) { }

  sendRequest(file : ImageSend) : Promise<any>{
    const httpOptions = {
      headers : new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    };
    return this.http.post(this.url, file, httpOptions).toPromise();
  }
}

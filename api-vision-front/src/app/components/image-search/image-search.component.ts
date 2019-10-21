import { Component, OnInit, Input } from '@angular/core';
import { ImageService } from 'src/app/services/image.service';
import { ImageSend } from 'src/app/models/image-send';
import { ImageResponse } from 'src/app/models/image-response';

@Component({
  selector: 'app-image-search',
  templateUrl: './image-search.component.html',
  styleUrls: ['./image-search.component.css']
})
export class ImageSearchComponent implements OnInit {
  file : string;
  
  imageResponse : Array<ImageResponse> = new Array()

  constructor(private imageService : ImageService) { }

  ngOnInit() {
  }
  
  send() {
    console.log(this.file)
    this.imageService.sendRequest(new ImageSend(this.file)).then(response => {
      this.imageResponse = response;
      console.log(this.imageResponse)
    }).catch(error =>{
      console.log(error)
    });
    
  }
}

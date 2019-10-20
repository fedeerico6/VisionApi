import { Component, OnInit, Input } from '@angular/core';
import { ImageResponse } from 'src/app/models/image-response';

@Component({
  selector: 'app-image-details',
  templateUrl: './image-details.component.html',
  styleUrls: ['./image-details.component.css']
})
export class ImageDetailsComponent implements OnInit {
  @Input()
  imageResponse : Array<ImageResponse> = new Array()
  
  constructor() { }

  ngOnInit() {
  }

}

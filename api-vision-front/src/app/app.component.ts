import { Component } from '@angular/core';
import { ImageResponse } from './models/image-response';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'api-vision-front';
  //imageResponse = new Array<ImageResponse>() // borrar
}

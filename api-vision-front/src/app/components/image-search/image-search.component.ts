import { Component, OnInit } from '@angular/core';
import { ImageService } from 'src/app/services/image.service';

@Component({
  selector: 'app-image-search',
  templateUrl: './image-search.component.html',
  styleUrls: ['./image-search.component.css']
})
export class ImageSearchComponent implements OnInit {
  file : File;
  constructor(private imageService : ImageService) { }

  ngOnInit() {
  }
  
  send() {
    alert("subido!");
    //let reader = new FileReader();
    //reader.readAsDataURL(this.file);
    console.log(this.file);
    this.imageService.sendRequest(this.file).then(response => {
    // mostrar la respuesta
    console.log(response);
    }).catch(error =>{
    });
    
  }
}

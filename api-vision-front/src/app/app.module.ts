import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http'; // para hacer peticiones http

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageSearchComponent } from './components/image-search/image-search.component';
import { ImageDetailsComponent } from './components/image-details/image-details.component';
import { from } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    ImageSearchComponent,
    ImageDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule // para peticiones http
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

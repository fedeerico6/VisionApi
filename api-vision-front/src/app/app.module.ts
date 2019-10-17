import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageSearchComponent } from './components/image-search/image-search.component';
import { ImageDetailsComponent } from './components/image-details/image-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ImageSearchComponent,
    ImageDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { UploadFilesComponent } from './components/upload-files/upload-files.component';
import { AddDataComponent } from './components/add-data/add-data.component';
import { SearchDataComponent } from './components/search-data/search-data.component';
import { routing } from './app.routing';
@NgModule({
  declarations: [
    AppComponent,
    UploadFilesComponent,
    AddDataComponent,
    SearchDataComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    routing,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

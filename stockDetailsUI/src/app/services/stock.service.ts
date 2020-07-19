import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import {StockData} from '../model/StockData';
@Injectable({
  providedIn: 'root'
})
export class StockService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    
    
    const httpOptions = {
      headers: new HttpHeaders()
    };
    httpOptions.headers.append('Access-Control-Allow-Origin', 'http://localhost:8080');
    httpOptions.headers.append('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    httpOptions.headers.append('Access-Control-Allow-Credentials', 'true');

    httpOptions.headers.append("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
    const req = new HttpRequest('POST', '//localhost:8080/upload', formData, {
      reportProgress: true,
      responseType: 'text',
      headers: httpOptions.headers
    });

    return this.http.request(req);
     
  }

  getData(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/getStock?name=` + encodeURIComponent(name));
    
  }

  addData(stock: StockData): Observable<any> {
    console.log("==============="+stock.stock)
    let headers = new HttpHeaders(); 
    headers.append('Access-Control-Allow-Origin', 'http://localhost:8080');
    headers.append('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    headers.append('Access-Control-Allow-Credentials', 'true');

    headers.append("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
  
    //headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/addStock', stock, {headers : headers})
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { StockService } from 'src/app/services/stock.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import {StockData} from 'src/app/model/StockData';
@Component({
  selector: 'app-search-data',
  templateUrl: './search-data.component.html',
  styleUrls: ['./search-data.component.css']
})
export class SearchDataComponent implements OnInit {

   
  message = '';
  
  headElements=[];
  @Input() searchText: string;
  
  stockList: StockData[] =[];
  constructor(private stockService: StockService) { }

  ngOnInit() {
     
  }

  searchData() {
    console.log(this.searchText);
    this.stockService.getData(this.searchText).subscribe(
      data => { 
        console.log(this.stockList );
          this.stockList = data;
          if(this.stockList.length ==0){
            this.searchText='';
            this.message = '0 records found for given search';
          }else{
          this.headElements = ['Quarter', 'StockName', 'Date    ', 'Open', 'High', 'Low', 'Close', 'Volume', 
          'PercentChangePrice', 'Days'];
          }
        },
          error => {
            console.log( "Failed to retrieve data! " + error );
            this.searchText='';
           });
  }
 

  }

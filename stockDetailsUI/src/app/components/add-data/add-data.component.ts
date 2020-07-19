import { Component, OnInit, Input } from '@angular/core';
import { StockService } from '../../services/stock.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import {StockData} from '../../model/StockData';
@Component({
  selector: 'add-data',
  templateUrl: './add-data.component.html',
  styleUrls: ['./add-data.component.css']
})
export class AddDataComponent implements OnInit {
 
  message: string;
  stock: StockData = new StockData();
  constructor(private stockService: StockService) { }

  ngOnInit() {
     
  }

  addData(){
    console.log(this.stock.stock);
    this.stockService.addData(this.stock).subscribe(
      data => {
      if(data === 1){
        this.message = 'Record added successful';
      }
  },err=> {
    this.message = 'Error while saving record' ;
  });
}
}

import { Component, OnInit } from '@angular/core';
import {Handyman} from '../shared/entities/handyman';
import {HandymanService} from "../shared/services/handyman-service";

@Component({
  selector: 'app-handyman-list-page',
  templateUrl: './handyman-list-page.component.html',
  styleUrls: ['./handyman-list-page.component.scss']
})
export class HandymanListPageComponent implements OnInit {

  public handymanList: Handyman[];


  constructor(private handymanService: HandymanService) { }

  ngOnInit() {
    this.getHandymanList().then((list => {
      this.handymanList = list;
    }));
  }

  private async getHandymanList() {
    return this.handymanService.getHandymanList();
  }
}

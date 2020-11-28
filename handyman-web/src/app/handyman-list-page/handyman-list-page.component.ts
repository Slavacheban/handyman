import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Handyman} from '../shared/entities/handyman';
import {HandymanService} from "../shared/services/handyman-service";

@Component({
  selector: 'app-handyman-list-page',
  templateUrl: './handyman-list-page.component.html',
  styleUrls: ['./handyman-list-page.component.scss']
})
export class HandymanListPageComponent implements OnInit {

  public handymanList: Handyman[];
  public columns: string [];

  @ViewChild('dateTemplate') dateTemplate: TemplateRef<any>;
  @ViewChild('actionsTemplate') actionsTemplate: TemplateRef<any>;


  constructor(private handymanService: HandymanService) { }

  ngOnInit() {

    this.columns = this.prepareDataTableColumns();
    this.getHandymanList().then((list => {
      this.handymanList = list;
    }));
  }

  private async getHandymanList() {
    return this.handymanService.getHandymanList();
  }

  private prepareDataTableColumns(): any[] {
    return [
      {prop: 'id', name: 'ID'},
      {prop: 'name', name: 'Handyman Name'},
      {prop: 'createDate', name: 'Create Date', cellTemplate: this.dateTemplate},
      {
        prop: 'actions',
        name: 'Actions',
        width: 120,
        canAutoResize: false,
        cellClass: 'actions-column',
        cellTemplate: this.actionsTemplate
      }
    ];
  }

  public updateHandyman(handyman: Handyman) {

  }

  public addHandyman() {

  }

  public deleteHandyman(handyman: Handyman) {

  }
}

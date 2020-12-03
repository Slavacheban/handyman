import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Handyman} from '../shared/entities/handyman';
import {HandymanService} from "../shared/services/handyman-service";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {ViewHandymanModalComponent} from "../view-handyman-modal/view-handyman-modal.component";
import {DatatableComponent} from "@swimlane/ngx-datatable";

@Component({
  selector: 'app-handyman-list-page',
  templateUrl: './handyman-list-page.component.html',
  styleUrls: ['./handyman-list-page.component.scss']
})
export class HandymanListPageComponent implements OnInit {

  public handymanList: Handyman[];
  public dtColumns;
  private bsModalRef: BsModalRef;

  @ViewChild('table') table: DatatableComponent;
  @ViewChild('dateTemplate') dateTemplate: TemplateRef<any>;
  @ViewChild('actionsTemplate') actionsTemplate: TemplateRef<any>;


  constructor(private handymanService: HandymanService,
              private modalService: BsModalService) { }

  ngOnInit() {
    this.dtColumns = this.prepareDataTableColumns();
    this.refreshTable();
  }

  private refreshTable() {
    this.handymanService.getHandymanList().then(list => {
      this.handymanList = this.prepareHandyman(list);
    });
  }

  private prepareDataTableColumns(): any[] {
    return [
      {prop: 'id', name: 'ID'},
      {prop: 'userDTO.firstName', name: 'Handyman Name'},
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
    const initialState = {
      id: null,
      callback: (result) => {
        if (result) {
          this.refreshTable();
        }
      }
    };

    const modalConfig = {
      class: 'modal-md',
      ignoreBackdropClick: true
    };
    const modalParams = Object.assign({}, modalConfig, {initialState});
    this.bsModalRef = this.modalService.show(ViewHandymanModalComponent, modalParams);
  }

  public deleteHandyman(handyman: Handyman) {

  }

  private prepareHandyman(list: Handyman[]) {
    list.forEach((handyman: Handyman) => {
      handyman._name = handyman.userDTO ? handyman.userDTO.firstName + ' ' + handyman.userDTO.lastName : 'no name';
    });
    return list;
  }
}

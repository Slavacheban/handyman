import {AfterViewInit, Component, TemplateRef, ViewChild} from '@angular/core';
import {Order} from "../shared/entities/order";
import {OrderService} from "../shared/services/order-service";
import {DatatableComponent} from "@swimlane/ngx-datatable";
import {BsModalRef} from "ngx-bootstrap/modal";
import {Handyman} from "../shared/entities/handyman";

@Component({
  selector: 'app-home-page',
  templateUrl: './order-list-page.component.html',
  styleUrls: ['./order-list-page.component.scss']
})
export class OrderListPageComponent implements AfterViewInit {
  public orderList: Order[];
  public dtColumns: any;
  private bsModalRef: BsModalRef;

  @ViewChild('table') table: DatatableComponent;
  @ViewChild('dateTemplate') dateTemplate: TemplateRef<any>;
  @ViewChild('currencyTemplate') currencyTemplate: TemplateRef<any>;
  @ViewChild('actionsTemplate') actionsTemplate: TemplateRef<any>;

  constructor(private orderService: OrderService) {
  }

  ngAfterViewInit(): void {
    setTimeout(() => {
      this.dtColumns = this.prepareDataTableColumns();
      this.refreshTable();
    }, 0)
  }

  private refreshTable() {
    this.orderService.getOrderList().then(list => {
      console.log(list);
      this.orderList = this.prepareOrders(list);
    });
  }

  private prepareDataTableColumns(): any[] {
    return [
      {prop: 'description', name: 'Description'},
      {prop: 'price', name: 'Price', cellTemplate: this.currencyTemplate},
      {prop: 'startDate', name: 'Start Date', cellTemplate: this.dateTemplate},
      {prop: 'finishDate', name: 'Finish Date', cellTemplate: this.dateTemplate},
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

  private prepareOrders(list: Order[]) {
    list.forEach((order: Order) => {
      console.log(order);
    });
    return list;
  }

  public updateOrder(order: Order) {

  }


}

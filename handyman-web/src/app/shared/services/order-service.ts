import {HttpBase} from "./http-base";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Constants} from "../constants/app.constants";
import {Order} from "../entities/order";

@Injectable({
  providedIn: "root"
})
export class OrderService extends HttpBase {

  readonly URL: string;

  constructor(httpClient: HttpClient,
              constants: Constants) {
    super(httpClient);
    this.URL = constants.API_URL + 'orders';
  }

  public async getOrderList(): Promise<Order[]> {
    return super.getAll(this.URL, Order, {}).toPromise();
  }
}

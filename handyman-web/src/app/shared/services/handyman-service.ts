import {HttpBase} from "./http-base";
import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Constants} from "../constants/app.constants";
import {Handyman} from "../entities/handyman";


@Injectable({
  providedIn: 'root'
})
export class HandymanService extends HttpBase {

  readonly URL: string;

  constructor(httpClient: HttpClient,
              constants: Constants) {
    super(httpClient);
    this.URL = constants.API_URL + 'handyman';
  }

  public async getHandymanList(): Promise<Handyman[]> {
    return super.getAll(this.URL, Handyman, {}).toPromise();
  }

  public async addHandyman(handyman: Handyman): Promise<Handyman> {
    return super.postForResult(this.URL, Handyman, {}, handyman).toPromise();
  }
}

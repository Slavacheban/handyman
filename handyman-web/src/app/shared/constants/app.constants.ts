import {Injectable} from "@angular/core";
import {GlobalJavaConstants} from "./global-java-constants";

@Injectable({
  providedIn: 'root'
})

export class Constants {

  public API_URL: string = 'http://localhost:8080/api/';

  // private getUrl() {
  //   return new GlobalJavaConstants().APP_HANDYMAN_LINK;
  // }
}

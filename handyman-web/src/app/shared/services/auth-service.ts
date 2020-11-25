import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from "../entities/user";
import {Constants} from "../constants/app.constants";
import {HttpBase} from "./http-base";

@Injectable({
  providedIn: 'root'
})
export class AuthService extends HttpBase{
  readonly ARI_URL;

  constructor(http: HttpClient,
              constants: Constants) {
    super(http);
    this.ARI_URL = constants.API_URL;
  }

  get token(): string {
    return ''
  }

  login(user: User): Observable<any> {
    return super.post(this.ARI_URL + 'auth/login/', User, {}, user)
  }

  logout() {

  }

  isAuthenticated(): boolean {
    return !!this.token
  }

  private setToken() {

  }
}

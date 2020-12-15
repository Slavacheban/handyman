import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from "../entities/user";
import {Constants} from "../constants/app.constants";
import {HttpBase} from "./http-base";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService extends HttpBase {
  readonly ARI_URL;

  constructor(http: HttpClient,
              constants: Constants) {
    super(http);
    this.ARI_URL = constants.API_URL;
  }

  get token(): string {
    return localStorage.getItem('sss');
  }

  login(user: User): Observable<any> {
    return super.post(this.ARI_URL + 'auth/login', User, {}, user)
      .pipe(
        tap(this.setToken)
      );
  }

  logout() {

  }

  isAuthenticated(): boolean {
    return !!this.token
  }

  private setToken(resp: string) {
    localStorage.setItem('sss', resp);
  }
}

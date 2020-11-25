import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../../shared/entities/user";
import {AuthService} from "../../shared/services/auth-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  public form: FormGroup;
  public user: User;

  constructor(
    private auth: AuthService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.form = new FormGroup({
      email: new FormControl(null, [
        Validators.required,
        Validators.email
      ]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(6)
      ])
    });
  }

  submit() {
    if (this.form.invalid) {
      return;
    }

    this.auth.login(this.user).subscribe(() => {
      this.form.reset();
      this.router.navigate(['/order', '1']);
    })
  }

}

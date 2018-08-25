import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  returnUrl: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private authenticationService: AuthenticationService
  ) {
    localStorage.removeItem('User');
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => this.returnUrl = params['returnUrl'] || 'patient/aggregate-data');
    localStorage.removeItem('User');
  }

  onSubmit() {
    const token = 'Basic: ' + btoa(this.username + ':' + this.password);
    if (this.authenticationService.authenticate(token)) {
      localStorage.setItem('User', this.username);
      console.log(this.returnUrl);
      this.router.navigateByUrl(this.returnUrl);
    } else {
      this.password = '';
    }
  }

}

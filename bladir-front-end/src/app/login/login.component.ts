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
  role: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private authenticationService: AuthenticationService
  ) {
    localStorage.removeItem('User');
    localStorage.removeItem('Role');
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => this.returnUrl = params['returnUrl']);
    localStorage.removeItem('User');
    localStorage.removeItem('Role');
  }

  onSubmit() {
    const token = 'Basic: ' + btoa(this.username + ':' + this.password);
    if (this.authenticationService.authenticate(token)) {
      localStorage.setItem('User', this.username);
      localStorage.setItem('Role', this.role);
      console.log(this.returnUrl);
      if (this.returnUrl) {
        this.router.navigateByUrl(this.returnUrl);
      } else {
        if (localStorage.getItem('Role') === 'Patient') {
          this.router.navigateByUrl('patient/aggregate-data');
        } else if (localStorage.getItem('Role') === 'Doctor') {
          this.router.navigateByUrl(('doctor/doctor-aggregate-data'));
        } else {
          console.log(localStorage.getItem('Role'));
        }
      }
    } else {
      this.password = '';
    }
  }

}

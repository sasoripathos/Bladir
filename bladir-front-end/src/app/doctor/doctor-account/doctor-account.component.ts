import {Component, OnInit} from '@angular/core';
import {User} from '../../user';

@Component({
  selector: 'app-doctor-account',
  templateUrl: './doctor-account.component.html',
  styleUrls: ['./doctor-account.component.css']
})
export class DoctorAccountComponent implements OnInit {

  user = new User(1234, 'admin', 'admin', 'admin', 'admin@doctor.ca', 'Female', 2);
  block = true;

  constructor() {
  }

  ngOnInit() {
  }

  onClicl() {
    this.block = !this.block;
  }

}

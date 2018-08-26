import {Component, OnInit} from '@angular/core';
import {User} from '../../user';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  user = new User(1234, 'admin', 'admin', 'admin', 'admin@admin.ca', 'Male', 1);
  block = true;

  constructor() {
  }

  ngOnInit() {
  }

  onClicl() {
    this.block = !this.block;
  }

}

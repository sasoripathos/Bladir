import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  aggregateActive: boolean;
  trendActive: boolean;

  constructor() {
    this.activateAggregate();
  }

  ngOnInit() {
  }

  activateAggregate() {
    this.aggregateActive = true;
    this.trendActive = false;
  }

  activateTrend() {
    this.aggregateActive = false;
    this.trendActive = true;
  }

  deactivate() {
    this.aggregateActive = false;
    this.trendActive = false;
  }

}

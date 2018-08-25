import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
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

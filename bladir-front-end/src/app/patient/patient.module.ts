import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientComponent } from './patient.component';
import { PatientRoutingModule } from './patient-routing.module';
import { AggregateDataComponent } from './aggregate-data/aggregate-data.component';
import { TrendDataComponent } from './trend-data/trend-data.component';

@NgModule({
  imports: [
    CommonModule,
    PatientRoutingModule
  ],
  declarations: [PatientComponent, AggregateDataComponent, TrendDataComponent]
})
export class PatientModule { }

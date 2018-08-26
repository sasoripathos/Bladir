import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DoctorRoutingModule } from './doctor-routing.module';
import { DoctorComponent } from './doctor.component';
import { DoctorAggregateDataComponent } from './doctor-aggregate-data/doctor-aggregate-data.component';
import { DoctorTrendDataComponent } from './doctor-trend-data/doctor-trend-data.component';
import { DoctorAccountComponent } from './doctor-account/doctor-account.component';
import { DoctorChartsComponent } from './doctor-charts/doctor-charts.component';

@NgModule({
  imports: [
    CommonModule,
    DoctorRoutingModule
  ],
  declarations: [DoctorComponent, DoctorAggregateDataComponent, DoctorTrendDataComponent, DoctorAccountComponent, DoctorChartsComponent]
})
export class DoctorModule { }

import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DoctorRoutingModule} from './doctor-routing.module';
import {DoctorComponent} from './doctor.component';
import {DoctorAggregateDataComponent} from './doctor-aggregate-data/doctor-aggregate-data.component';
import {DoctorTrendDataComponent} from './doctor-trend-data/doctor-trend-data.component';
import {DoctorAccountComponent} from './doctor-account/doctor-account.component';
import {DoctorChartsComponent} from './doctor-charts/doctor-line-chart/doctor-line-chart.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DoctorBarChartComponent} from './doctor-charts/doctor-bar-chart/doctor-bar-chart.component';
import {NgxEchartsModule} from 'ngx-echarts';

@NgModule({
  imports: [
    CommonModule,
    DoctorRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxEchartsModule
  ],
  declarations: [
    DoctorComponent,
    DoctorAggregateDataComponent,
    DoctorTrendDataComponent,
    DoctorAccountComponent,
    DoctorChartsComponent,
    DoctorBarChartComponent
  ]
})
export class DoctorModule {
}

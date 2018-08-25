import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientComponent } from './patient.component';
import { PatientRoutingModule } from './patient-routing.module';
import { AggregateDataComponent } from './aggregate-data/aggregate-data.component';
import { TrendDataComponent } from './trend-data/trend-data.component';
import { AccountComponent } from './account/account.component';
import {NgxEchartsModule} from 'ngx-echarts';
import {BarChartComponent} from '../charts/bar-chart/bar-chart.component';
import {LineChartComponent} from '../charts/line-chart/line-chart.component';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';

@NgModule({
  imports: [
    CommonModule,
    PatientRoutingModule,
    NgxEchartsModule,
    HttpClientModule,
    HttpModule,
  ],
  declarations: [
    PatientComponent,
    AggregateDataComponent,
    TrendDataComponent,
    AccountComponent,
    BarChartComponent,
    LineChartComponent]
})
export class PatientModule { }

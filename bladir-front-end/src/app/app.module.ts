import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { LoginComponent } from './login/login.component';
// import {PatientRoutingModule} from './patient/patient-routing.module';
import {PatientModule} from './patient/patient.module';
// import { BarChartComponent } from './charts/bar-chart/bar-chart.component';
// import { LineChartComponent } from './charts/line-chart/line-chart.component';
import {NgxEchartsModule} from 'ngx-echarts';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxEchartsModule,
    // PatientRoutingModule,
    PatientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

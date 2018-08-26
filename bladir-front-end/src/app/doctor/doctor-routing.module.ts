import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DoctorAggregateDataComponent} from './doctor-aggregate-data/doctor-aggregate-data.component';
import {DoctorTrendDataComponent} from './doctor-trend-data/doctor-trend-data.component';
import {DoctorAccountComponent} from './doctor-account/doctor-account.component';


const doctorRouter: Routes = [
  {
    path: '',
    redirectTo: './doctor-aggregate-data',
    pathMatch: 'full'
  },
  {
    path: 'doctor-aggregate-data',
    component: DoctorAggregateDataComponent
  },
  {
    path: 'doctor-trend-data',
    component: DoctorTrendDataComponent
  },
  {
    path: 'doctor-account',
    component: DoctorAccountComponent
  }
];


@NgModule({
  imports: [RouterModule.forChild(doctorRouter)],
  exports: [RouterModule]
})
export class DoctorRoutingModule {
}

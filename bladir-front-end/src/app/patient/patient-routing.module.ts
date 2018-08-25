import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AggregateDataComponent} from './aggregate-data/aggregate-data.component';
import {TrendDataComponent} from './trend-data/trend-data.component';
import {AccountComponent} from './account/account.component';

const patientRouter: Routes = [
  {
    path: '',
    redirectTo: './aggregate-data',
    pathMatch: 'full'
  },
  {
    path: 'aggregate-data',
    component: AggregateDataComponent
  },
  {
    path: 'trend-data',
    component: TrendDataComponent
  },
  {
    path: 'account',
    component: AccountComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(patientRouter)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }

import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AggregateDataComponent} from './aggregate-data/aggregate-data.component';

const patientRouter: Routes = [
  {
    path: '',
    redirectTo: './aggregate-data',
    pathMatch: 'full'
  },
  {
    path: 'aggregate-data',
    component: AggregateDataComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(patientRouter)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }

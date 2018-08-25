import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientComponent } from './patient.component';
import { PatientRoutingModule } from './patient-routing.module';

@NgModule({
  imports: [
    CommonModule,
    PatientRoutingModule
  ],
  declarations: [PatientComponent]
})
export class PatientModule { }

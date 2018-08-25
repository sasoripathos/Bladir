import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {PatientComponent} from './patient/patient.component';
import {RegisterComponent} from './register/register.component';
import {AuthGuardService} from './services/auth-guard.service';

export const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'patient',
    component: PatientComponent,
    canActivate: [AuthGuardService],
    loadChildren: './patient/patient.module#PatientModule'
  },
  {
    path: 'register',
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

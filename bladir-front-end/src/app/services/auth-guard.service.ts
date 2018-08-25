import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(
    private router: Router
  ) {
  }

  canActivate(route, state) {
    if (localStorage.getItem('User')) {
      return true;
    } else {
      this.router.navigate(['/'], {queryParams: {returnUrl: state.url}});
      return false;
    }
  }
}

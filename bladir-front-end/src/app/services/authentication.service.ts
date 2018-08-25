import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private token = 'Basic: YWRtaW46YWRtaW4xMjM0';

  constructor() {
  }

  authenticate(token) {
    return this.token === token;
  }
}

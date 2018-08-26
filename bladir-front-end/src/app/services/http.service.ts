import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private url = 'http://localhost:8080/echart';

  constructor(
    private http: HttpClient
  ) {
  }

  getBarChart(date: string) {
    const url = this.url + '/barchart/' + localStorage.getItem('User') + '?date=' + date;
    return this.http.get(url, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    });
  }

  getLineChart(value: string, times: string) {
    const url = this.url + '/linechart/' + localStorage.getItem('User') + '?value=' + value + '&times=' + times;
    return this.http.get(url, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    });
  }
}

import {Component, OnInit} from '@angular/core';
import {EChartOption} from 'echarts';
import {HttpService} from '../../../services/http.service';

@Component({
  selector: 'app-doctor-line-chart',
  templateUrl: './doctor-line-chart.component.html',
  styleUrls: ['./doctor-lin-chart.component.css']
})
export class DoctorChartsComponent implements OnInit {
  echartsIntance: any;

  chartOption: EChartOption;
  dataLoaded = false;

  constructor(
    private httpService: HttpService
  ) {
  }

  ngOnInit() {
    this.onSubmit('WBC', '5');
  }

  onChartInit(ec) {
    this.echartsIntance = ec;
  }

  onSubmit(value, times) {
    this.dataLoaded = true;
    this.httpService.getLineChart(value, times)
      .subscribe((response: Response) => {
        this.chartOption = {
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: [value]
          },
          toolbox: {
            show: true,
            feature: {
              dataZoom: {
                yAxisIndex: 'none'
              },
              dataView: {readOnly: false},
              magicType: {type: ['line', 'bar']},
              restore: {},
              saveAsImage: {}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: response['xAxisData']
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name: value,
              type: 'line',
              data: response['series'][0]['data'],
              markPoint: {
                data: [
                  {type: 'max', name: 'max'},
                  {type: 'min', name: 'min'}
                ]
              },
              markLine: {
                data: [
                  {type: 'average', name: 'average'}
                ]
              }
            }
          ]
        };
        console.log(this.chartOption);
      });
  }

}

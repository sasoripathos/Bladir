import {Component, OnInit} from '@angular/core';
import * as echarts from 'echarts';
import {EChartOption} from 'echarts';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'app-line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.css']
})
export class LineChartComponent implements OnInit {
  echartsIntance: any;
  chartOption: EChartOption;
  dataLoaded = false;
  comments: string;

  constructor(
    private httpService: HttpService
  ) {
  }

  ngOnInit() {
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
        this.comments = response['comment'];
        console.log(this.chartOption);
      });
  }

}

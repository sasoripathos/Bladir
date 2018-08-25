import {Component, OnInit} from '@angular/core';
import * as echarts from 'echarts';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.css']
})
export class BarChartComponent implements OnInit {

  echartsIntance: any;
  barData;


  posList = [
    'left', 'right', 'top', 'bottom',
    'inside',
    'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
    'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
  ];

  configParameters = {
    rotate: {
      min: -90,
      max: 90
    },
    align: {
      options: {
        left: 'left',
        center: 'center',
        right: 'right'
      }
    },
    verticalAlign: {
      options: {
        top: 'top',
        middle: 'middle',
        bottom: 'bottom'
      }
    },
    position: {
      options: echarts.util.reduce(this.posList, function (map, pos) {
        map[pos] = pos;
        return map;
      }, {})
    },
    distance: {
      min: 0,
      max: 100
    }
  };

  config = {
    rotate: 90,
    align: 'left',
    verticalAlign: 'middle',
    position: 'insideBottom',
    distance: 15,
    onChange: function () {
      this.labelOption = {
        normal: {
          rotate: this.config.rotate,
          align: this.config.align,
          verticalAlign: this.config.verticalAlign,
          position: this.config.position,
          distance: this.config.distance
        }
      };
      this.myChart.setOption({
        series: [{
          label: this.labelOption
        }, {
          label: this.labelOption
        }, {
          label: this.labelOption
        }, {
          label: this.labelOption
        }]
      });
    }
  };


  labelOption = {
    normal: {
      show: true,
      position: this.config.position,
      distance: this.config.distance,
      align: this.config.align,
      verticalAlign: this.config.verticalAlign,
      rotate: this.config.rotate,
      formatter: '{c}  {name|{a}}',
      fontSize: 16,
      rich: {
        name: {
          textBorderColor: '#fff'
        }
      }
    }
  };

  option = {
    color: ['#003366', '#006699', '#e5323e'],
    tooltip: {
      trigger: 'axis',
      axisPointer: {
        type: 'shadow'
      }
    },
    legend: {
      'data': ['Lower Bound', 'Test Value', 'Upper Bound']
    },
    toolbox: {
      show: true,
      orient: 'vertical',
      left: 'right',
      top: 'center',
      feature: {
        mark: {show: true},
        dataView: {show: true, readOnly: false},
        magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
        restore: {show: true},
        saveAsImage: {show: true}
      }
    },
    calculable: true,
    xAxis: [
      {
        type: 'category',
        axisTick: {show: false},
        data: ['WBC', 'RBC', 'MVC']
      }
    ],
    yAxis: [
      {
        type: 'value'
      }
    ],
    series: [
      {
        'name': 'Lower Bound',
        'type': 'bar',
        'data': [25, 25, 40],
        'barGap': 0
      },
      {
        'name': 'Test Value',
        'type': 'bar',
        'data': [30, 50, 15],
        'barGap': 0
      },
      {
        'name': 'Upper Bound',
        'type': 'bar',
        'data': [40, 40, 45],
        'barGap': 0
      }

    ]
  };

  constructor(
    private httpService: HttpService
  ) {
  }

  ngOnInit() {
    this.httpService.getBarChart('20180825')
      .subscribe(
      (response: Response) => {
        console.log(response);
        this.option = {
          color: ['#003366', '#006699', '#e5323e'],
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow'
            }
          },
          legend: {
            data: response['legend']['data']
            // 'data': ['Lower Bound', 'Test Value', 'Upper Bound']
          },
          toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
              mark: {show: true},
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
              restore: {show: true},
              saveAsImage: {show: true}
            }
          },
          calculable: true,
          xAxis: [
            {
              type: 'category',
              axisTick: {show: false},
              data: response['xAxisData']
            }
          ],
          yAxis: [
            {
              type: 'value'
            }
          ],
          series: response['series']
          // [
          // {
          //   'name': 'Lower Bound',
          //   'type': 'bar',
          //   'data': [25, 25, 30],
          //   'barGap': 0
          // },
          // {
          //   'name': 'Test Value',
          //   'type': 'bar',
          //   'data': [30, 50, 15],
          //   'barGap': 0
          // },
          // {
          //   'name': 'Upper Bound',
          //   'type': 'bar',
          //   'data': [40, 40, 45],
          //   'barGap': 0
          // }

          // ]
        };
        // const series = JSON.stringify(response['series']);
        // const legend = JSON.stringify(response['legend']);
        // const xAxisData = JSON.stringify(response['xAxisData']);
        // this.option.series = response.series;
        // this.option.legend = legend;
        // this.option.xAxis[2] = xAxisData;
        // const barData = response.series;
        // console.log(response);
        // this.barData = barData;
        // this.updateData();
        // this.updateData(response['legend'], response['series'], response['xAxisData']);
        // this.option['lengend'] = response['legend'];
        // console.log(this.option['series']);
        // this.option['series'][0]['data'] = JSON.parse(JSON.stringify(response['series'][0]['data']));
        // console.log(JSON.parse(JSON.stringify(response['series'][0]['data'])));
        // this.option['xAxiaData'] = response['xAxiaData'];
        // console.log(response['series']);
        // // console.log(response.series);
        // console.log(this.option['seires'][0]['data']);
        console.log(this.option);
        // this.updateData()

      },
      error => {
        console.log(error);
      }
    );
  }

  onChartInit(ec) {
    this.echartsIntance = ec;
  }

  updateData() {
    const series = this.barData['series'];
    const legend = this.barData['legend'];
    const xAxisData = this.barData['xAxisData'];

    const new_option = {
      color: ['#003366', '#006699', '#e5323e'],
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'shadow'
        }
      },
      legend: legend,
      toolbox: {
        show: true,
        orient: 'vertical',
        left: 'right',
        top: 'center',
        feature: {
          mark: {show: true},
          dataView: {show: true, readOnly: false},
          magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
          restore: {show: true},
          saveAsImage: {show: true}
        }
      },
      calculable: true,
      xAxis: xAxisData,
      yAxis: [
        {
          type: 'value'
        }
      ],
      series: series
    };

    this.option = new_option;
  }
}

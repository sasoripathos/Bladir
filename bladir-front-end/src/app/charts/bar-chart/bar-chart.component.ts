import {Component, OnInit} from '@angular/core';
import * as echarts from 'echarts';
import {EChartOption} from 'echarts';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.css']
})
export class BarChartComponent implements OnInit {

  echartsIntance: any;

  // chartOption: EChartOption = {
  //   xAxis: {
  //     type: 'category',
  //     data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  //   },
  //   yAxis: {
  //     type: 'value'
  //   },
  //   series: [{
  //     data: [820, 932, 901, 934, 1290, 1330, 1320],
  //     type: 'line'
  //   }]
  // };


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
        'data': [
          25,
          25,
          25
        ],
        'barGap': 0
      },
      {
        'name': 'Test Value',
        'type': 'bar',
        'data': [
          30,
          50,
          15
        ],
        'barGap': 0
      },
      {
        'name': 'Upper Bound',
        'type': 'bar',
        'data': [
          40,
          40,
          45
        ],
        'barGap': 0
      }

    ]
  };

  constructor(
    private httpClient: HttpClient,
  ) {
  }

  ngOnInit() {
    this.httpClient.get('http://localhost:8080/echart/barchart/jerry?date=20180825', {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    }).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      }
    );
  }

  onChartInit(ec) {
    this.echartsIntance = ec;
  }

}

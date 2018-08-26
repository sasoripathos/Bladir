import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorBarChartComponent } from './doctor-bar-chart.component';

describe('DoctorBarChartComponent', () => {
  let component: DoctorBarChartComponent;
  let fixture: ComponentFixture<DoctorBarChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorBarChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorBarChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

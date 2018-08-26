import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorTrendDataComponent } from './doctor-trend-data.component';

describe('DoctorTrendDataComponent', () => {
  let component: DoctorTrendDataComponent;
  let fixture: ComponentFixture<DoctorTrendDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorTrendDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorTrendDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

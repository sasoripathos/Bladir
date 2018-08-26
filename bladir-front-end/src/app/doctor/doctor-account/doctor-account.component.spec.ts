import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorAccountComponent } from './doctor-account.component';

describe('DoctorAccountComponent', () => {
  let component: DoctorAccountComponent;
  let fixture: ComponentFixture<DoctorAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

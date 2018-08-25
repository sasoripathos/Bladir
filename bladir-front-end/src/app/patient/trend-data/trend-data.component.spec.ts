import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrendDataComponent } from './trend-data.component';

describe('TrendDataComponent', () => {
  let component: TrendDataComponent;
  let fixture: ComponentFixture<TrendDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrendDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrendDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HumidityCalculationComponent } from './humidity-calculation.component';

describe('HumidityCalculationComponent', () => {
  let component: HumidityCalculationComponent;
  let fixture: ComponentFixture<HumidityCalculationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HumidityCalculationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HumidityCalculationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

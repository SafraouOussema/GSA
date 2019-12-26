import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeratisationComponent } from './deratisation.component';

describe('DeratisationComponent', () => {
  let component: DeratisationComponent;
  let fixture: ComponentFixture<DeratisationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeratisationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeratisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

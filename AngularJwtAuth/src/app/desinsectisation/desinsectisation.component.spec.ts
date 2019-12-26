import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesinsectisationComponent } from './desinsectisation.component';

describe('DesinsectisationComponent', () => {
  let component: DesinsectisationComponent;
  let fixture: ComponentFixture<DesinsectisationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesinsectisationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesinsectisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

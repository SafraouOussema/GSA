import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocauxComponent } from './locaux.component';

describe('LocauxComponent', () => {
  let component: LocauxComponent;
  let fixture: ComponentFixture<LocauxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocauxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocauxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

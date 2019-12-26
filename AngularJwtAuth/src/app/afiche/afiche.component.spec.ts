import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AficheComponent } from './afiche.component';

describe('AficheComponent', () => {
  let component: AficheComponent;
  let fixture: ComponentFixture<AficheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AficheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AficheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

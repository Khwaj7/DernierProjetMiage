import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MembreFormComponent } from './membre-form.component';

describe('MembreFormComponent', () => {
  let component: MembreFormComponent;
  let fixture: ComponentFixture<MembreFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MembreFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MembreFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

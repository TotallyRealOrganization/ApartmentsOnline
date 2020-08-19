import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedApartmentsComponent } from './saved-apartments.component';

describe('SavedApartmentsComponent', () => {
  let component: SavedApartmentsComponent;
  let fixture: ComponentFixture<SavedApartmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SavedApartmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SavedApartmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

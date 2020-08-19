import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostedApartmentsComponent } from './posted-apartments.component';

describe('PostedApartmentsComponent', () => {
  let component: PostedApartmentsComponent;
  let fixture: ComponentFixture<PostedApartmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostedApartmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostedApartmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

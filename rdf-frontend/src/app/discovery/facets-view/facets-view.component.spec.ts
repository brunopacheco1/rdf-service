import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacetsViewComponent } from './facets-view.component';

describe('FacetsViewComponent', () => {
  let component: FacetsViewComponent;
  let fixture: ComponentFixture<FacetsViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FacetsViewComponent]
    });
    fixture = TestBed.createComponent(FacetsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

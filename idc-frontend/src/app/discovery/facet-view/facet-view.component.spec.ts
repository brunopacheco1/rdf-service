import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacetViewComponent } from './facet-view.component';

describe('FacetViewComponent', () => {
  let component: FacetViewComponent;
  let fixture: ComponentFixture<FacetViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FacetViewComponent]
    });
    fixture = TestBed.createComponent(FacetViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

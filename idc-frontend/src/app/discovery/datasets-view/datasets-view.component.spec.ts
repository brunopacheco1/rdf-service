import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatasetsViewComponent } from './datasets-view.component';

describe('DatasetsViewComponent', () => {
  let component: DatasetsViewComponent;
  let fixture: ComponentFixture<DatasetsViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DatasetsViewComponent]
    });
    fixture = TestBed.createComponent(DatasetsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

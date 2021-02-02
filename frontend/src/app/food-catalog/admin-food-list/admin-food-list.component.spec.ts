import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFoodListComponent } from './admin-food-list.component';

describe('AdminFoodListComponent', () => {
  let component: AdminFoodListComponent;
  let fixture: ComponentFixture<AdminFoodListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFoodListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFoodListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

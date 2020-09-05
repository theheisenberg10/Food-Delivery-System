import { TestBed } from '@angular/core/testing';

import { MyServService } from './my-serv.service';

describe('MyServService', () => {
  let service: MyServService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyServService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

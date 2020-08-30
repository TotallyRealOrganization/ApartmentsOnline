import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { TestBed, fakeAsync, tick } from "@angular/core/testing";
import { HttpClient } from "@angular/common/http";

import { ApartmentService } from './apartment.service';
import { Apartment } from '../models/Apartment';


describe('ApartmentService', () => {
  let service: ApartmentService;
  let httpTestingController: HttpTestingController

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ApartmentService]
    });
    service = TestBed.inject(ApartmentService);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  afterEach(() => {
    // After every test, assert that there are no more pending requests.
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it("should search create and return a new apartment",
  fakeAsync(() => {
      let response = {
          resultCount: 1,
          results: [
              {
                userID: "a",
                numBeds: 1,
                numBaths: 1,
                address: "2 st",
                area: 1,
                imgURL: "goog.com", 
                price: 12,
                utilDetails: "stuff", 
                restrictions: "none"  
              }
          ]
      };
    
      let a: Apartment = new Apartment("a",1,1,"2 st", 1,"goog.com",12,"stuff","none")
      // Perform a request (this is fakeAsync to the responce won't be called until tick() is called)
      service.postApartment(a)
    
      // Expect a call to this URL
      const req = httpTestingController.expectOne(
          "http://localhost:8080/api/apartment"
      );
      // Assert that the request is a GET.
      expect(req.request.method).toEqual("POST");
      // Respond with this data when called
      req.flush(response);
      
      // Call tick whic actually processes te response
      tick();
  })
  );

  it("should search get all apartments",
  fakeAsync(() => {
      let response = {
          resultCount: 1,
          results: [
              {
                id: "1",
                email: "test@test.com",
                password: "password",
                fullName: "Test McTest"
              }
          ]
      };
    
      
      // Perform a request (this is fakeAsync to the responce won't be called until tick() is called)
      service.getAllApartments()
    
      // Expect a call to this URL
      const req = httpTestingController.expectOne(
          "http://localhost:8080/api/apartment/"
      );
      console.log(req.request.url);
      // Assert that the request is a GET.
      expect(req.request.method).toEqual("GET");
      // Respond with this data when called
      req.flush(response);
      // Call tick whic actually processes te response
      tick();
  })
  );
});

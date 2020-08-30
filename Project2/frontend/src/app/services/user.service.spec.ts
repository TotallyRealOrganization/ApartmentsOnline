import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { TestBed, fakeAsync, tick } from "@angular/core/testing";
import { HttpClient } from "@angular/common/http";

import { UserService } from './user.service';
import { User } from '../models/User';

describe('UserService', () => {
  let httpTestingController: HttpTestingController;
  let userService: UserService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    userService = TestBed.inject(UserService);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  afterEach(() => {
    // After every test, assert that there are no more pending requests.
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(userService).toBeTruthy();
  });

  it("search should fetch a user",
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
        userService.fetchUser("1")

        // Expect a call to this URL
        const req = httpTestingController.expectOne(
            "http://localhost:8080/api/user/1"
        );
        // Assert that the request is a GET.
        expect(req.request.method).toEqual("GET");
        // Respond with this data when called
        req.flush(response);

        // Call tick whic actually processes te response
        tick();
    })
  );
  it("search login and return a user",
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

        let u: User = new User("test@test.com", "password", "Test McTest")
        // Perform a request (this is fakeAsync to the responce won't be called until tick() is called)
        userService.login(u)

        // Expect a call to this URL
        const req = httpTestingController.expectOne(
            "http://localhost:8080/api/user/login"
        );
        // Assert that the request is a GET.
        expect(req.request.method).toEqual("POST");
        // Respond with this data when called
        req.flush(response);

        // Call tick whic actually processes te response
        tick();
    })
  );
  it("should search register and return a new user",
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
      
        let u: User = new User("test@test.com", "password", "Test McTest")
        // Perform a request (this is fakeAsync to the responce won't be called until tick() is called)
        userService.register(u)
      
        // Expect a call to this URL
        const req = httpTestingController.expectOne(
            "http://localhost:8080/api/user/register"
        );
        // Assert that the request is a GET.
        expect(req.request.method).toEqual("POST");
        // Respond with this data when called
        req.flush(response);
        
        // Call tick whic actually processes te response
        tick();
    })
  );
  it("should return return null if getUser is called before a user is logged in",
    () => expect(userService.getUser()).toBeFalsy
  )

});

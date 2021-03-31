package org.upgrad.upstac.testrequest;

import org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.upstac.config.security.UserLoggedInService;
import org.upgrad.upstac.users.User;

import java.time.LocalDate;

@RestController
public class TestRequestController {

    @Autowired
    private UserLoggedInService UserLoggedInService;

@Autowired
TestRequestService testRequestService;

    @PostMapping("/api/testrequest")
    public TestRequest createTestRequest(@RequestBody TestRequestInput testRequestInput){

        User loggedInUser = UserLoggedInService.getLoggedInUser();
        return testRequestService.saveTestRequest(loggedInUser,testRequestInput);
        
    }
}

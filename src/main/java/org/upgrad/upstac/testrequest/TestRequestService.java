package org.upgrad.upstac.testrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.upstac.users.User;

import java.time.LocalDate;
import java.util.List;

@Service

public class TestRequestService {
    @Autowired
    TestRequestRepository testRequestRepository;

    public TestRequest saveTestRequest(User loggedInUser, TestRequestInput testRequestInput) {
        TestRequest testRequest = new TestRequest();
        testRequest.address = testRequestInput.address;
        testRequest.age = testRequestInput.age;
        testRequest.email = testRequestInput.email;
        testRequest.setPhoneNumber(testRequestInput.getPhoneNumber());
        testRequest.setPinCode(testRequestInput.getPinCode());
        testRequest.setName(testRequestInput.getName());
        testRequest.setGender(testRequestInput.getGender());
        testRequest.setCreatedBy(loggedInUser);
        testRequest.setCreated(LocalDate.now());
        testRequest.setStatus(RequestStatus.INITIATED);


        return testRequestRepository.save(testRequest);
    }

    public boolean validateTestRequestCanBeSaved(TestRequestInput testRequestInput) {
        List<TestRequest> testRequests = testRequestRepository.findByEmailOrPhoneNumber(testRequestInput.getEmail(), testRequestInput.getPhoneNumber());
        for (TestRequest testrequest : testRequests) {
            if (testrequest.getStatus().equals(RequestStatus.COMPLETED) == false) {
                return false;
            }
        }
        return false;

    }
}

package org.upgrad.upstac.testrequest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  TestRequestRepository extends JpaRepository<TestRequest,Long> {
    List<TestRequest> findByEmailOrPhoneNumber(String email,String phoneNumber);


}

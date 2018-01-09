package com.myapp.cloud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myapp.cloud.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository <Payment,Long> {

}

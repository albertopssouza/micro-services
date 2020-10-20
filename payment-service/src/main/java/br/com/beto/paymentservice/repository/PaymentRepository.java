/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beto.paymentservice.repository;

import br.com.beto.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alber
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    public Payment findByOrderId(int orderId);
    
}

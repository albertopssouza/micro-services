/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beto.paymentservice.service;

import br.com.beto.paymentservice.entity.Payment;
import br.com.beto.paymentservice.repository.PaymentRepository;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alber
 */
@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository repository;
    
    public List<Payment> listPayment() {
        return repository.findAll();
    }
    
    public String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "false";
    } 
    
    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    public Payment findPaymentHistoryByOrderId(int orderId) {
        return repository.findByOrderId(orderId);
    }
    
}

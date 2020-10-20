/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beto.orderservice.service;

import br.com.beto.orderservice.common.Payment;
import br.com.beto.orderservice.common.TransactionRequest;
import br.com.beto.orderservice.common.TransactionResponse;
import br.com.beto.orderservice.entity.Ordem;
import br.com.beto.orderservice.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author alber
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate template;
    
    public TransactionResponse saveOrder(TransactionRequest request) {
        Ordem order = request.getOrder();
        repository.save(order);
        
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        
        Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        String response = (paymentResponse.getPaymentStatus().equals("success")) ? "Pagamento processado com sucesso" : "Falha no pagamento";
        
        return new TransactionResponse(order, 
                paymentResponse.getAmount(), 
                paymentResponse.getTransactionId(),
                response);
    }
    
    public List<Ordem> listOrder() {
        return repository.findAll();
    }
    
}

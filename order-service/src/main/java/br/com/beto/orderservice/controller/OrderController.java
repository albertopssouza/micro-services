/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beto.orderservice.controller;

import br.com.beto.orderservice.common.TransactionRequest;
import br.com.beto.orderservice.common.TransactionResponse;
import br.com.beto.orderservice.entity.Ordem;
import br.com.beto.orderservice.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alber
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private OrderService service;
    
    @GetMapping
    public List<Ordem> listOrder() {
        return service.listOrder();
    }
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return service.saveOrder(request);
    }
    
}

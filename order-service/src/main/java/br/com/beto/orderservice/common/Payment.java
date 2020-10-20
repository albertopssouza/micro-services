/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beto.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alber
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private int id;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
    
}

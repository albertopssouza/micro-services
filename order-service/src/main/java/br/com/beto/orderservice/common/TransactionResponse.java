/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beto.orderservice.common;

import br.com.beto.orderservice.entity.Ordem;
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
public class TransactionResponse {
    
    private Ordem order;
    private double amount;
    private String transactionId;
    private String message;
    
}

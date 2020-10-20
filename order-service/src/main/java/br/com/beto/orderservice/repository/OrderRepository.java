/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beto.orderservice.repository;

import br.com.beto.orderservice.entity.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alber
 */
public interface OrderRepository extends JpaRepository<Ordem, Integer> {
    
}

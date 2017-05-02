/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.AirCraftEntity;
import entity.CreditCardEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Integer>{
    @Query(value ="select * from CreditCard where cardNumber=?",nativeQuery = true)
    CreditCardEntity getCreditCardByCardNumber(int cardNumber);
    
    @Query(value ="select * from CreditCard where cardNumber=? and validateNumber=?",nativeQuery = true)
    CreditCardEntity getCreditCardByValidateNumber(int cardNumber,int validate);
    
    @Query(value ="select * from CreditCard where cardNumber=? and securityNumber=?",nativeQuery = true)
    CreditCardEntity getCreditCardBySecurityNumber(int cardNumber,int security);
}

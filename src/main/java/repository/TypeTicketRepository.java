/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.TypeTicketEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTicketRepository extends CrudRepository<TypeTicketEntity, Integer>{
    @Query(value ="select * from TypeTicket where typeName=?",nativeQuery = true)
    TypeTicketEntity getTypeTicketByName(String name);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ClassTicketEntity;
import entity.LuggageEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuggageRepository extends CrudRepository<LuggageEntity, Integer>{
    @Query(value ="select * from Luggage where lugName=?",nativeQuery = true)
    LuggageEntity getLuggageByName(String name);
}

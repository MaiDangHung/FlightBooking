/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ClassTicketEntity;
import entity.RouteEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTicketRepository extends CrudRepository<ClassTicketEntity, Integer>{
    @Query(value ="select * from ClassTicket where classTicketName=?",nativeQuery = true)
    ClassTicketEntity getClassTicketByName(String name);
}

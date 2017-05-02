/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ClassTicketEntity;
import entity.TicketEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Integer>{
    @Query(value ="select distinct Ticket.* from Ticket,Flight where Ticket.flightID=Flight.flightID and flight.flightID=?",nativeQuery = true)
    List<TicketEntity> getNumberSeatByFlightID(int flightID);
}

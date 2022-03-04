package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ticket.ReserveTicket;

@Repository
public interface ReservedTicketRepository extends MongoRepository<ReserveTicket, Long> {
}
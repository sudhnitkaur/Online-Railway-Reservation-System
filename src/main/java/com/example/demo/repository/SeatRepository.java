package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ticket.Trains_Seats;

@Repository
public interface SeatRepository extends MongoRepository<Trains_Seats, String> {
}
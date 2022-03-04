package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.ticket.ReserveSeats;
import com.example.demo.model.ticket.Seat_Id;

public interface ReservedSeatsRepository extends MongoRepository<ReserveSeats, Seat_Id> {
}
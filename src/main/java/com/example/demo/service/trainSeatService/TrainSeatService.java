package com.example.demo.service.trainSeatService;

import com.example.demo.model.ticket.Trains_Seats;

public interface TrainSeatService {
    public String addData();

    public Trains_Seats getTrainSeats(String train_no);
}
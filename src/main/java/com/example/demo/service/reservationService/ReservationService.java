package com.example.demo.service.reservationService;



import java.time.LocalDate;

import com.example.demo.model.ticket.ReserveTicket;
import com.example.demo.model.ticket.Seat_Id;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.model.ticket.TicketStatus;

public interface ReservationService {
    public TicketStatus reserveTicket(Ticket ticket);

    public String reserveSeat(String train_no, String class_name, LocalDate date, Long pnr);

    public String reservedTicket(ReserveTicket reservedTicket);

    public ReserveTicket getTicket(long pnr);

    public boolean ticketExistByPNR(long pnr);

    public String ticketCancellation(long pnr);

    public String seatCancellation(String seat_no, String class_name, Seat_Id seat_id);

    public String availableSeats(String start,String destination,LocalDate date);

    public String availableAccommodation(String train_no,LocalDate date);
}
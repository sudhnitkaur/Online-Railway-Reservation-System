package com.example.demo.model.ticket;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "Reserved-Ticket")
public class ReserveTicket {

    @Transient
    public static final String SEQUENCE_NAME = "ticket_sequence";

    @Id
    private Long pnr;
    private Ticket ticket;
    private Long transactional_id;
    private Long account_no;
    private String email_address;
    private String status;
    private LocalDateTime booking_time;
    private Double amount;
	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getTicket() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPnr(long pnr2) {
		// TODO Auto-generated method stub
		
	}
	
}
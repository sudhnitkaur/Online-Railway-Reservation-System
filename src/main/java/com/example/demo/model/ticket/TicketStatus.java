package com.example.demo.model.ticket;


	import lombok.*;

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	@ToString
	public class TicketStatus {
	    private Long pnr;
	    private String status;
	    private String seat_no;
	}


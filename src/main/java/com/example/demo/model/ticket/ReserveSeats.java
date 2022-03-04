package com.example.demo.model.ticket;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "Reserve-Seats")
public class ReserveSeats {
    @Id
    @Field(name = "seat_id")
    private Seat_Id seat_id;
    private Map<String, Map<Integer, Long>> seats; // classes -> (seatNo,pnr)

    private Map<String, Integer> coaches_per_class; // classes -> no of coaches

	public Map<String, Map<Integer, Long>> getSeats() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
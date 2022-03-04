package com.example.demo.model.ticket;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "Train-Seats")
public class Trains_Seats {
    public Trains_Seats(Object object, Map<String, Integer> coaches_no, Map<String, Integer> seat) {
		// TODO Auto-generated constructor stub
	}
	@Id
    private String train_no;
    private Map<String, Integer> coaches_per_class; // quantity per coach
    private Map<String, Integer> seats_per_coach; // coach name & total seat
	public Object getTrain_no() {
		// TODO Auto-generated method stub
		return null;
	}
}
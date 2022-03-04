package com.example.demo.model.train;

import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "Trains")
public class Train {

    @Id
    @Autowired
    private String train_no;
    private String train_name;
    private String start_from;
    private LocalTime departure_time;
    private String to_destination;
    private LocalTime arrival_time;
    private String train_type;
    private List<String> run_days;
    private Map<String, Double> coaches_fair = new LinkedHashMap<>();
    private int train_length;
    private boolean active;
    private Map<String, Detail> route;
	public Map<String, Integer> getCoaches_fair() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getTrain_length() {
		// TODO Auto-generated method stub
		return 0;
	}

    

	

}

//Trains is the name of the collections.
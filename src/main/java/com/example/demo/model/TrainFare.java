package com.example.demo.model;
	import java.time.LocalTime;

	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	import lombok.ToString;

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	@ToString
	public class TrainFare {
	    private int id;
	    private String train_name;
	    private String train_no;
	    private String origin;
	    private String departure_time;
	    private LocalTime destination;
	    private LocalTime arrival_time;
	    
	}

	
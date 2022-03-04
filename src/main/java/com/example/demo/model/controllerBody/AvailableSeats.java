package com.example.demo.model.controllerBody;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AvailableSeats {
	private String start;
    private String destination;
    private LocalDate localDate;
}

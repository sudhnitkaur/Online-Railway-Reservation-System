package com.example.demo.model.controllerBody;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccomodationBody {
	 private String train_no;
	    private LocalDate date;
}

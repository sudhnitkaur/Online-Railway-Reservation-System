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
public class TimeTable {
    private int id;
    private String train_name;
    private String train_no;
    private String start_from;
    private String to_destination;
    private LocalTime time_arrival;
    private LocalTime time_departure;


}

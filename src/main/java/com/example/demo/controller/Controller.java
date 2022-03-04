package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.user.User;
import com.example.demo.service.SequenceGenerator;
import com.example.demo.service.UserServiceImpl;

import com.example.demo.*;
import com.example.demo.service.trainSeatService.TrainSeatService;
import com.example.demo.service.trainService.TrainService;

import io.swagger.annotations.ApiOperation;
import com.example.demo.*;

import com.example.demo.model.TimeTable;
import com.example.demo.model.TrainBetweenStation;
import com.example.demo.model.controllerBody.AvailableSeats;
import com.example.demo.model.ticket.ReserveTicket;
import com.example.demo.model.ticket.SeatData;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.model.ticket.TicketStatus;
import com.example.demo.model.train.Train;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/users")
public class Controller {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private SequenceGenerator sequenceGenerator;
	 @Autowired
	  private TrainService trainService;
	 @Autowired
	    private TrainSeatService trainSeatService;
	    @Autowired
	    private ReservationService reservationService;
	@GetMapping("/getEmail/{id}")
	public String getEmailId(@PathVariable long id) {
		return userServiceImpl.getEmailAddress(id);
	} 
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		user.setId(sequenceGenerator.getUserSequenceNmber("user_sequence"));
		return userServiceImpl.addUser(user);
	}
	
	
	@PostMapping("/addAllUser")
	public String addAllUser(@RequestBody List<User> users) {
		return userServiceImpl.addAllUser(users);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userServiceImpl.getAllUser();
	}
	
	@GetMapping("/userExistbyId/{id}")
	public boolean userExistById(@PathVariable long id) {
		return userServiceImpl.userExistById(id);
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		return userServiceImpl.updateUser(user);
	}
	
	@GetMapping("/userExistById/{id}")
	public User getUser(@PathVariable long id) {
		return userServiceImpl.getUser(id);
	}
	
	@DeleteMapping("/delete")
	public String deleteUser(@RequestBody User user) {
		return userServiceImpl.deleteUser(user);
	}
	
// *--------------------------------------- Ticket Reservation Functionality ---------------------------------------------*

    
    @GetMapping( "/welcome")
    
    public String welcome() {
        return "Welcome to Pakistan Railway Reservation portal";
    }

    @PostMapping( "/reserveTicket")

    public TicketStatus reserveTicket(@RequestBody Ticket ticket){return reservationService.reserveTicket(ticket);}

    @PostMapping("/reservedTicket")
   
    public String reservedTicket(@RequestBody ReserveTicket reservedTicket){return reservationService.reservedTicket(reservedTicket);}

    @GetMapping( "/ticketExistByPNR/{pnr}")
   
      boolean chkPNR(@PathVariable long pnr){return reservationService.ticketExistByPNR(pnr);}

    @GetMapping("  /getTicket/{pnr}")
   
    public ReserveTicket getTicket(@PathVariable long pnr){return reservationService.getTicket(pnr);}

    @GetMapping(" /cancelTicket/{pnr}")

    public String cancelTicket(@PathVariable long pnr){return reservationService.ticketCancellation(pnr);}

    @PostMapping("  /cancelSeat")
    
    public String cancelSeat(@RequestBody SeatData seatData){return reservationService.seatCancellation(seatData.getSeat_no(),seatData.getClass_name(),seatData.getSeat_id());}

    @PostMapping("  /availableSeats")
 
    public String availableSeats(@RequestBody AvailableSeats availableSeats){return reservationService.availableSeats(availableSeats.getStart(),availableSeats.getDestination(),availableSeats.getLocalDate());}

    
    // *----------------------------------------------------------------------------------*
 
    @GetMapping("  /timeTable/{city}")
     public List<TimeTable> displayTimeTable(@PathVariable String city) {
        return trainService.displayTimeTable(city);
    }

    @GetMapping("  /trainTimeTable/{city_name}")
    public String displayTimeToTable(@PathVariable String city_name) { return trainService.displayTimeTableByYourCity(city_name); }
   
    @GetMapping("  trainsBetweenStation/{origin}:{destination}")
    public String getTrainBetweenStationToTable(@PathVariable String origin, @PathVariable String destination) { return trainService.trainsBetweenStationToTable(origin, destination); }

    @GetMapping("  trainsBetweenStations/{origin}:{destination}")
    public List<TrainBetweenStation> getTrainBetweenStation(@PathVariable String origin, @PathVariable String destination) { return trainService.trainsBetweenStation(origin, destination); }
   
    
    @GetMapping( "  trainFare/{origin}:{destination}")
    public String getTrainFareToTable(@PathVariable String origin, @PathVariable String destination) {
        return trainService.trainFareToTable(origin, destination);
    }

    @GetMapping(  "  trainFares/{origin}:{destination}")
    public List<TrainBetweenStation> getTrainFare(@PathVariable String origin, @PathVariable String destination) {
        return trainService.trainFare(origin, destination);
    }
    
    @PutMapping("/updateAllTrains")
    public String updateAllTrains(@RequestBody List<Train> list) {
        return trainService.updateData(list);
    }

    @GetMapping("/customUpdate")
      
    public String customUpdate() {
        return trainService.customUpdation();
    }

    @GetMapping("  /displayAllTrains")
    public List<Train> displayAllTrains() {
        return trainService.displayAllTrains();
    }

    @GetMapping("  /displaytrains/{trainsNo}")
      
    public String displayTrains(@PathVariable String trainsNo) {
        return trainService.displayTrain(trainsNo);
    }

    @GetMapping("  /getTrainByTrainNo/{train_no}")
    public int getTrainByTrainNo(@PathVariable String train_no) {
        return trainService.getTrainByTrainNo(train_no);
    }

    @PostMapping("/addTrain")
    public String addTrain(@RequestBody Train train){return trainService.addTrain(train);}

    @DeleteMapping("/deleteTrain/{train_no}:{confirmation}")
    public String deleteTrain(@PathVariable String train_no , @PathVariable String confirmation){return trainService.deleteTrain(train_no,confirmation);};

    @DeleteMapping("/deleteAllTrains/{confirmation}")
    
    public String deleteAllTrains(String confirmation){return trainService.deleteAllTrains(confirmation);}

    @GetMapping("  trainExistByTrainNo/{train_no}")
    public boolean trainExistByTrainNo(@PathVariable String train_no) { return trainService.trainExistByTrainNo(train_no);}

    @GetMapping("  displaytrain/{trainsNo}")
    public String displayTrain(@PathVariable String trainsNo) {
        return trainService.displayTrainToTable(trainsNo);
    // *---------------------------------------------*

// The @PathVariable annotation is used to extract the value from the URI. It is most suitable for the RESTful web service where the URL contains some value.
	
}}

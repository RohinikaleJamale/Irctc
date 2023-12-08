package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Passenger;
import com.example.demo.entity.Ticket;
import com.example.demo.services.PassengerServiceI;

@RestController
public class PassengerController {
	@Autowired
private PassengerServiceI passengerServiceI;
	
	@PostMapping(value = "BookTicket",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody  Passenger psg) {
		 Ticket bookTicket = passengerServiceI.bookTicket(psg);
		return new ResponseEntity<Ticket>(bookTicket,HttpStatus.CREATED);
		
	}
	@PostMapping("/bookticketwebclient")
	 public ResponseEntity<Ticket> bookticketWebclient(@RequestBody Passenger psg){
		  Ticket webClient = passengerServiceI.bookTicketWebClient(psg);
		  return new ResponseEntity<Ticket>(webClient,HttpStatus.OK);
	 }
	
	
	
	
	
	
	
	
}

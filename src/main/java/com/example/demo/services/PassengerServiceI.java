package com.example.demo.services;

import com.example.demo.entity.Passenger;
import com.example.demo.entity.Ticket;

public interface PassengerServiceI {
 public  Ticket bookTicket(Passenger psg);
 public Ticket bookTicketWebClient(Passenger psg); 
}

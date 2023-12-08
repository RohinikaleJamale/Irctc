package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Ticket {
	private int tid;
	 private String ticketStatus;
	 private String pnr;
	 private double price;
}

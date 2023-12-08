package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Passenger {
	@Id
 private int pid;
 private String fname;
 private String lname;
 private String f;
 private String t;
 private String doj;
}


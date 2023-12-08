package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.entity.Passenger;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.PassengerRepository;

import reactor.core.publisher.Mono;

@Service
public class PassengerServiceImpl implements PassengerServiceI {
	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public Ticket bookTicket(Passenger psg) {
		Passenger save = passengerRepository.save(psg);

		String url = "http://localhost:9090/BookTicket";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Ticket> book = rt.postForEntity(url, psg, Ticket.class);
		Ticket body = book.getBody();
		return body;
	}

	public Ticket bookTicketWebClient(Passenger psg) {

		String url = "http://localhost:9090/BookTicket";
		WebClient webClient = WebClient.create();
		Ticket block = webClient.post().
				uri(url).
				contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.APPLICATION_JSON).
				body(BodyInserters.fromValue(psg)).
				retrieve().bodyToMono(Ticket.class)
				.block();
		System.out.println(block);

		return block;

	}

}

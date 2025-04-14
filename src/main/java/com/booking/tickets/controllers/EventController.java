package com.booking.tickets.controllers;

import com.booking.tickets.events.Event;
import com.booking.tickets.events.Organizer;
import com.booking.tickets.events.Product;
import com.booking.tickets.repositories.EventRepository;
import com.booking.tickets.repositories.OrganizerRepository;
import com.booking.tickets.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/organizers")
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    @GetMapping(path = "/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping(path = "/eventsByOrganizerId")
    public List<Event> getEventsByOrganizerId(@RequestParam("organizerId") int organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    @GetMapping(path = "/events/{eventId}")
    public Event getEventById(@PathVariable("eventId") int eventId) {
        return eventRepository
                .findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event with id " + eventId + " not found"));
    }

    @GetMapping(path = "/products")
    public List<Product> getProductsByEventId(@RequestParam("eventId") int eventId) {
        return productRepository.findByEventId(eventId);
    }
}

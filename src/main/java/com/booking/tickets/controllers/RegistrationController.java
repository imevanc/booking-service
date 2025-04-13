package com.booking.tickets.controllers;

import com.booking.tickets.registration.Registration;
import com.booking.tickets.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationRepository.create(registration);
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration getRegistrationByTicketCode(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository
                .findByTicketCode(ticketCode)
                .orElseThrow(() -> new IllegalArgumentException("Registration with ticket code " + ticketCode + " not found"));
    }

    @PutMapping(path = "/{ticketCode}")
    public Registration updateRegistration(@PathVariable("ticketCode") String ticketCode,
                                           @RequestBody Registration registration) {
        registration = new Registration(registration.id(), registration.productId(), ticketCode, registration.attendeeName());
        return registrationRepository.update(registration);
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void deleteRegistration(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}

package com.booking.tickets.repositories;

import com.booking.tickets.events.Organizer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizerRepository {
    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Organizer 1", "Description 1"),
            new Organizer(102, "Organizer 2", "Description 2"),
            new Organizer(103, "Organizer 3", "Description 3")
    );

    public List<Organizer> findAll() {
        return organizers;
    }
}

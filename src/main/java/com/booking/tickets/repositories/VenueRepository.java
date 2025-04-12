package com.booking.tickets.repositories;

import com.booking.tickets.events.Venue;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {
    private final List<Venue> venues = List.of(
            new Venue(201, "Venue 1", "Location 1", "City 1", "Country 1"),
            new Venue(202, "Venue 2", "Location 2", "City 2", "Country 2"),
            new Venue(203, "Venue 3", "Location 3", "City 3", "Country 3")
    );

    public Optional<Venue> getById(int id) {
        return venues.stream()
                .filter(venue -> venue.id() == id)
                .findFirst();
    }
}

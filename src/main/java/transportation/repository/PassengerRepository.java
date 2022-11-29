package repository;

import entity.Passenger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PassengerRepository {
    private List<Passenger> passengers = new ArrayList<>();
    private long id = 0L;

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(final List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<Passenger> getAllPassengers() {
        return new ArrayList<>(passengers);
    }

    public Passenger save(final Passenger passenger) {
        id++;
        passenger.setId(id);

        passengers.add(passenger);

        return passenger;
    }

    public Passenger find(final long id) {
        return passengers.stream().filter(passenger -> passenger.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Cannot find passenger with " + id + " id"));
    }

    public Passenger set(final Passenger passenger) {
        final Passenger saved = find(passenger.getId());

        saved.setFullName(passenger.getFullName());

        return saved;
    }

    public void delete(final long id) {
        setPassengers(passengers.stream().filter(passenger -> !passenger.getId().equals(id)).collect(Collectors.toList()));
    }
}

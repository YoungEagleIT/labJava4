package repository;

import entity.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DriverRepository {
    private List<Driver> drivers = new ArrayList<>();
    private long id = 0L;

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(final List<Driver> drivers) {
        this.drivers = drivers;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<Driver> getAllDrivers() {
        return new ArrayList<>(drivers);
    }

    public Driver save(final Driver driver) {
        id++;
        driver.setId(id);

        drivers.add(driver);
        return driver;
    }

    public Driver find(final long id) {
        return drivers.stream().filter(driver -> driver.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Cannot find driver with " + id + " id"));
    }

    public Driver set(final Driver driver) {
        final Driver saved = find(driver.getId());

        saved.setFullName(driver.getFullName());
        saved.setPhone(driver.getPhone());

        return saved;
    }

    public void delete(final long id) {
        setDrivers(drivers.stream().filter(driver -> !driver.getId().equals(id)).collect(Collectors.toList()));
    }
}

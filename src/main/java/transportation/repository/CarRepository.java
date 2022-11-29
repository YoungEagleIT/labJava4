package repository;

import entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    private List<Car> cars = new ArrayList<>();
    private long id = 0L;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(final List<Car> cars) {
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public Car save(final Car car) {
        id++;
        car.setId(id);

        cars.add(car);
        return car;
    }

    public Car find(final long id) {
        return cars.stream().filter(car -> car.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Cannot find car with " + id + " id"));
    }

    public Car set(final Car car) {
        final Car saved = find(car.getId());

        saved.setModel(car.getModel());
        saved.setCapacity(car.getCapacity());

        return saved;
    }

    public void delete(final long id) {
        setCars(cars.stream().filter(car -> !car.getId().equals(id)).collect(Collectors.toList()));
    }
}

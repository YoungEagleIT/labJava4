package mapper;

import dto.CarDTO;
import entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDTO toDTO(final Car car) {
        final CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setCapacity(car.getCapacity());
        carDTO.setModel(carDTO.getModel());
        return carDTO;
    }

    public Car toEntity(final CarDTO carDTO) {
        final Car car = new Car();
        car.setId(carDTO.getId());
        car.setCapacity(carDTO.getCapacity());
        car.setModel(carDTO.getModel());
        return car;
    }
}

package service.impl;

import dto.CarDTO;
import entity.Car;
import mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;
import service.CarService;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final CarMapper carMapper;

    public CarServiceImpl() {
        carRepository = new CarRepository();
        carMapper = new CarMapper();
    }

    @Override
    public CarDTO read(final Long id) {
        final Car foundCar = carRepository.find(id);
        return carMapper.toDTO(foundCar);
    }

    @Override
    public CarDTO create(final CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        car = carRepository.save(car);
        return carMapper.toDTO(car);
    }

    @Override
    public CarDTO update(final CarDTO carDTO) {
        final Car car = carRepository.set(carMapper.toEntity(carDTO));
        return carMapper.toDTO(car);
    }

    @Override
    public CarDTO delete(final Long id) {
        final CarDTO carDTO = carMapper.toDTO(carRepository.find(id));
        carRepository.delete(id);
        return carDTO;
    }
}

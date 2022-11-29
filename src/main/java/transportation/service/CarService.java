package service;

import dto.CarDTO;

public interface CarService {
    CarDTO read(final Long id);

    CarDTO create(final CarDTO carDTO);

    CarDTO update(final CarDTO carDTO);

    CarDTO delete(final Long id);
}

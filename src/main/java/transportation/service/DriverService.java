package service;

import dto.DriverDTO;

public interface DriverService {
    DriverDTO read(final Long id);

    DriverDTO create(final DriverDTO driverDTO);

    DriverDTO update(final DriverDTO driverDTO);

    DriverDTO delete(final Long id);
}

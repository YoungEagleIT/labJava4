package service.impl;

import dto.CarDTO;
import dto.DriverDTO;
import entity.Car;
import entity.Driver;
import mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DriverRepository;
import service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private final DriverRepository driverRepository;

    @Autowired
    private final DriverMapper driverMapper;

    public DriverServiceImpl() {
        driverRepository = new DriverRepository();
        driverMapper = new DriverMapper();
    }

    @Override
    public DriverDTO read(final Long id) {
        final Driver foundDriver = driverRepository.find(id);
        return driverMapper.toDTO(foundDriver);
    }

    @Override
    public DriverDTO create(final DriverDTO driverDTO) {
        Driver driver = driverMapper.toEntity(driverDTO);
        driver = driverRepository.save(driver);
        return driverMapper.toDTO(driver);
    }

    @Override
    public DriverDTO update(final DriverDTO driverDTO) {
        final Driver driver = driverRepository.set(driverMapper.toEntity(driverDTO));
        return driverMapper.toDTO(driver);
    }

    @Override
    public DriverDTO delete(final Long id) {
        final DriverDTO driverDTO = driverMapper.toDTO(driverRepository.find(id));
        driverRepository.delete(id);
        return driverDTO;
    }
}

package service.impl;

import dto.PassengerDTO;
import entity.Passenger;
import mapper.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PassengerRepository;
import service.PassengerService;

public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private final PassengerRepository passengerRepository;

    @Autowired
    private final PassengerMapper passengerMapper;

    public PassengerServiceImpl() {
        passengerRepository = new PassengerRepository();
        passengerMapper = new PassengerMapper();
    }

    @Override
    public PassengerDTO read(final Long id) {
        final Passenger foundPassenger = passengerRepository.find(id);
        return passengerMapper.toDTO(foundPassenger);
    }

    @Override
    public PassengerDTO create(final PassengerDTO passengerDTO) {
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.toDTO(passenger);
    }

    @Override
    public PassengerDTO update(final PassengerDTO passengerDTO) {
        final Passenger passenger = passengerRepository.set(passengerMapper.toEntity(passengerDTO));
        return passengerMapper.toDTO(passenger);
    }

    @Override
    public PassengerDTO delete(final Long id) {
        final PassengerDTO passengerDTO = passengerMapper.toDTO(passengerRepository.find(id));
        passengerRepository.delete(id);
        return passengerDTO;
    }
}

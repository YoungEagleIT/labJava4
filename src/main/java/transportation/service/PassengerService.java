package service;

import dto.PassengerDTO;

public interface PassengerService {
    PassengerDTO read(final Long id);

    PassengerDTO create(final PassengerDTO passengerDTO);

    PassengerDTO update(final PassengerDTO passengerDTO);

    PassengerDTO delete(final Long id);
}

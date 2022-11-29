package mapper;

import dto.PassengerDTO;
import entity.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {
    public PassengerDTO toDTO(final Passenger passenger) {
        final PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(passenger.getId());
        passengerDTO.setFullName(passenger.getFullName());
        return passengerDTO;
    }

    public Passenger toEntity(final PassengerDTO passengerDTO) {
        final Passenger passenger = new Passenger();
        passenger.setId(passengerDTO.getId());
        passenger.setFullName(passengerDTO.getFullName());
        return passenger;
    }
}

package resource;

import dto.PassengerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.PassengerService;
import service.impl.PassengerServiceImpl;

@RestController
@RequestMapping("api/passenger")
public class PassengerResource {
    @Autowired
    private final PassengerService passengerService = new PassengerServiceImpl();

    @GetMapping("/{id}")
    public PassengerDTO getPassenger(final @PathVariable Long id) {
        return passengerService.read(id);
    }

    @PostMapping
    public PassengerDTO postPassenger(final @Validated @RequestBody PassengerDTO passengerDTO) {
        return passengerService.create(passengerDTO);
    }

    @PutMapping
    public PassengerDTO putPassenger(final @Validated @RequestBody PassengerDTO passengerDTO) {
        return passengerService.update(passengerDTO);
    }

    @DeleteMapping("/{id}")
    public PassengerDTO deletePassenger(final @PathVariable Long id) {
        return passengerService.delete(id);
    }
}

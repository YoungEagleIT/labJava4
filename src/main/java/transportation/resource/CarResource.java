package resource;

import dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.CarService;
import service.impl.CarServiceImpl;

@RestController
@RequestMapping("api/car")
public class CarResource {
    @Autowired
    private final CarService carService = new CarServiceImpl();

    @GetMapping("/{id}")
    public CarDTO getCar(final @PathVariable Long id) {
        return carService.read(id);
    }

    @PostMapping
    public CarDTO postCar(final @Validated @RequestBody CarDTO carDTO) {
        return carService.create(carDTO);
    }

    @PutMapping
    public CarDTO putCar(final @Validated @RequestBody CarDTO carDTO) {
        return carService.update(carDTO);
    }

    @DeleteMapping("/{id}")
    public CarDTO deleteCar(final @PathVariable Long id) {
        return carService.delete(id);
    }
}

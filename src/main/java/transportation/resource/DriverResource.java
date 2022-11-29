package resource;

import dto.DriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.DriverService;
import service.impl.DriverServiceImpl;

@RestController
@RequestMapping("api/driver")
public class DriverResource {
    @Autowired
    private final DriverService driverService = new DriverServiceImpl();

    @GetMapping("/{id}")
    public DriverDTO getDriver(final @PathVariable Long id) {
        return driverService.read(id);
    }

    @PostMapping
    public DriverDTO postDriver(final @Validated @RequestBody DriverDTO driverDTO) {
        return driverService.create(driverDTO);
    }

    @PutMapping
    public DriverDTO putDriver(final @Validated @RequestBody DriverDTO driverDTO) {
        return driverService.update(driverDTO);
    }

    @DeleteMapping("/{id}")
    public DriverDTO deleteDriver(final @PathVariable Long id) {
        return driverService.delete(id);
    }
}

package mapper;

import dto.DriverDTO;
import entity.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {
    public DriverDTO toDTO(final Driver driver) {
        final DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(driver.getId());
        driverDTO.setFullName(driver.getFullName());
        driverDTO.setPhone(driver.getPhone());
        return driverDTO;
    }

    public Driver toEntity(final DriverDTO driverDTO) {
        final Driver driver = new Driver();
        driver.setId(driverDTO.getId());
        driver.setFullName(driverDTO.getFullName());
        driver.setPhone(driverDTO.getPhone());
        return driver;
    }
}

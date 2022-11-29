package entity;

import enumerate.OrderState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String addressStart;
    private LocalDateTime arrivedTime;
    private String addressEnd;
    private LocalDateTime deliveredTime;
    private Long idDriver;
    private Long idCar;
    private Long idPassenger;
    private OrderState state;
    private BigDecimal payment;
}

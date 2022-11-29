package dto;

import enumerate.OrderState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    @NotBlank
    private String addressStart;
    private LocalDateTime arrivedTime;
    @NotBlank
    private String addressEnd;
    private LocalDateTime deliveredTime;
    @NotNull
    private Long idDriver;
    @NotNull
    private Long idCar;
    @NotNull
    private Long idPassenger;
    @NotNull
    private OrderState state;
    private BigDecimal payment;
}

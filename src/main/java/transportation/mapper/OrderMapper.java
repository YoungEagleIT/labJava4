package mapper;

import dto.OrderDTO;
import entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(final Order order) {
        final OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setAddressStart(order.getAddressStart());
        orderDTO.setArrivedTime(order.getArrivedTime());
        orderDTO.setAddressEnd(order.getAddressEnd());
        orderDTO.setDeliveredTime(order.getDeliveredTime());
        orderDTO.setIdDriver(order.getIdDriver());
        orderDTO.setIdCar(order.getIdCar());
        orderDTO.setIdPassenger(order.getIdPassenger());
        orderDTO.setState(order.getState());
        orderDTO.setPayment(order.getPayment());
        return orderDTO;
    }

    public Order toEntity(final OrderDTO orderDTO) {
        final Order order = new Order();
        order.setId(orderDTO.getId());
        order.setAddressStart(orderDTO.getAddressStart());
        order.setArrivedTime(orderDTO.getArrivedTime());
        order.setAddressEnd(orderDTO.getAddressEnd());
        order.setDeliveredTime(orderDTO.getDeliveredTime());
        order.setIdDriver(orderDTO.getIdDriver());
        order.setIdCar(orderDTO.getIdCar());
        order.setIdPassenger(orderDTO.getIdPassenger());
        order.setState(orderDTO.getState());
        order.setPayment(orderDTO.getPayment());
        return order;
    }
}

package service.impl;

import dto.CarDTO;
import dto.OrderDTO;
import entity.Car;
import entity.Order;
import mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;
import service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final OrderMapper orderMapper;

    public OrderServiceImpl() {
        orderRepository = new OrderRepository();
        orderMapper = new OrderMapper();
    }

    @Override
    public OrderDTO read(final Long id) {
        final Order foundOrder = orderRepository.find(id);
        return orderMapper.toDTO(foundOrder);
    }

    @Override
    public OrderDTO create(final OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO update(final OrderDTO orderDTO) {
        final Order order = orderRepository.set(orderMapper.toEntity(orderDTO));
        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO delete(final Long id) {
        final OrderDTO orderDTO = orderMapper.toDTO(orderRepository.find(id));
        orderRepository.delete(id);
        return orderDTO;
    }
}

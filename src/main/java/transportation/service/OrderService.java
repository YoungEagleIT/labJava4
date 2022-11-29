package service;

import dto.OrderDTO;

public interface OrderService {
    OrderDTO read(final Long id);

    OrderDTO create(final OrderDTO orderDTO);

    OrderDTO update(final OrderDTO orderDTO);

    OrderDTO delete(final Long id);
}

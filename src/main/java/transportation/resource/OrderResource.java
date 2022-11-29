package resource;

import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.OrderService;
import service.impl.OrderServiceImpl;

@RestController
@RequestMapping("api/order")
public class OrderResource {
    @Autowired
    private final OrderService orderService = new OrderServiceImpl();

    @GetMapping("/{id}")
    public OrderDTO getOrder(final @PathVariable Long id) {
        return orderService.read(id);
    }

    @PostMapping
    public OrderDTO postOrder(final @Validated @RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @PutMapping
    public OrderDTO putOrder(final @Validated @RequestBody OrderDTO orderDTO) {
        return orderService.update(orderDTO);
    }

    @DeleteMapping("/{id}")
    public OrderDTO deleteOrder(final @PathVariable Long id) {
        return orderService.delete(id);
    }
}

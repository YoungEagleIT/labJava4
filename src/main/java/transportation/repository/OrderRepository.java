package repository;

import entity.Driver;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    private long id = 0L;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(final List<Order> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public Order save(final Order order) {
        id++;
        order.setId(id);

        orders.add(order);

        return order;
    }

    public Order find(final long id) {
        return orders.stream().filter(order -> order.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Cannot find order with " + id + " id"));
    }

    public Order set(final Order order) {
        final Order saved = find(order.getId());

        saved.setAddressStart(order.getAddressStart());
        saved.setArrivedTime(order.getArrivedTime());
        saved.setAddressEnd(order.getAddressEnd());
        saved.setDeliveredTime(order.getDeliveredTime());
        saved.setIdDriver(order.getIdDriver());
        saved.setIdCar(order.getIdCar());
        saved.setIdPassenger(order.getIdPassenger());
        saved.setState(order.getState());
        saved.setPayment(order.getPayment());

        return saved;
    }

    public void delete(final long id) {
        setOrders(orders.stream().filter(order -> !order.getId().equals(id)).collect(Collectors.toList()));
    }
}

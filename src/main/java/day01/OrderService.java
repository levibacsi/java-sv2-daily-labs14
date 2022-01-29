package day01;

import java.time.LocalDate;
import java.util.*;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public long countOrdersByStatus(String status){
        return orders.stream()
                .filter(o->o.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersBetweenDates (LocalDate from, LocalDate until){
        return orders.stream()
                .filter(o->o.getOrderDate().isAfter(from) && o.getOrderDate().isBefore(until))
                .toList();
    }

    public boolean isOrderWithLessProductsThanLimit(int limit){
        return orders.stream()
                .mapToInt(order -> order.getProducts().size())
                .anyMatch(o->o < limit);

    }
    public Order getOrderWithMaxNumberOfProducts(){
        return orders.stream()
                .max(Comparator.comparingInt(p->p.getProducts().size()))
                .orElseThrow(()-> new IllegalStateException("Empty list"));
    }

    public List<Order> findOrdersWithProductCategory(String category){
        return orders.stream()
                .filter(order -> order.getProducts()
                        .stream()
                        .anyMatch(p->p.getCategory().equals(category)))
                        .toList();
    }

    public List<Order> findOrdersByStatus (String status){
        return orders.stream()
                .filter(o->o.getStatus().equals(status))
                .toList();
    }

    public List<Product> findProductsOverPrice (int price){
        return orders.stream()
                .flatMap(o->o.getProducts().stream())
                .filter(product -> product.getPrice() >price)
                .toList();
    }

    public List<Order> sortOrdersByStatusAndOrderDate(){
        return orders.stream()
                        .sorted(Comparator.comparing(Order::getStatus)
                        .thenComparing(Order::getOrderDate))
                        .toList();
    }




}

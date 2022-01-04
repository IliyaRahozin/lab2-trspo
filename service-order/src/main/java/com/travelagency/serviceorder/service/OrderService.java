package com.travelagency.serviceorder.service;

import com.travelagency.serviceorder.api.dto.IdentityDto;
import com.travelagency.serviceorder.api.dto.OrderOut;
import com.travelagency.serviceorder.api.dto.TripDto;
import com.travelagency.serviceorder.repo.OrderRepo;
import com.travelagency.serviceorder.repo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final String URL_USER ="http://192.168.49.2:30001/user/";
    private final String URL_TRIP ="http://192.168.49.2:30000/trips/";

    private final String LOCAL_URL_USER = "http://localhost:8081/user/";
    private final String LOCAL_URL_TRIP = "http://localhost:8080/trips/";

    private final OrderRepo orderRepo;

    // All trips from Database
//    public List<Order> fetchAll() {
//        return orderRepo.findAll();
//    }

    public List<OrderOut> fetchAll(){
        List<Order> orders = orderRepo.findAll();

        List<OrderOut> ordersOut = new ArrayList<>();
        List<IdentityDto> userList = new ArrayList<>();
        List<TripDto> tripList = new ArrayList<>();

        for (Order order: orders) {
            RestTemplate restTemplate = new RestTemplate();

            String str_user = Long.toString(order.getUserId());
            String str_trip = Long.toString(order.getTripId());

            IdentityDto user = restTemplate.getForObject( URL_USER + order.getUserId(), IdentityDto.class);
            TripDto trip = restTemplate.getForObject(URL_TRIP + order.getTripId(), TripDto.class);

            userList.add(user);
            tripList.add(trip);

            OrderOut orderOut = new OrderOut(order, userList, tripList);
            ordersOut.add(orderOut);
        }
        return  ordersOut;

    }

    // Find by id
    public OrderOut fetchById(long id) throws IllegalArgumentException  {
        final Optional<Order> optionalOrder = orderRepo.findById(id);

        //List<OrderOut> orderOutList;

        List<IdentityDto> userList = new ArrayList<>();
        List<TripDto> tripList = new ArrayList<>();

        Order order;
        if (optionalOrder.isEmpty()) throw new IllegalArgumentException("Trip not found");
        else {
            order = optionalOrder.get();
            RestTemplate restTemplate = new RestTemplate();

            String str_user = Long.toString(order.getUserId());
            String str_trip = Long.toString(order.getTripId());

            IdentityDto user = restTemplate.getForObject(URL_USER + order.getUserId(), IdentityDto.class);
            TripDto trip = restTemplate.getForObject(URL_TRIP + order.getTripId(), TripDto.class);
            userList.add(user);
            tripList.add(trip);

            OrderOut orderOut = new OrderOut(order, userList, tripList);
            return orderOut;
        }
        //throw new RuntimeException("Unimplemented");
    }

    // Return created id instance
    public long createOrder(Long userId, Long tripId) {
        final Order order = new Order(userId, tripId);
        final Order savedOrder = orderRepo.save(order);
        return savedOrder.getId();
        //throw new RuntimeException("Unimplemented");
    }

    public void updateOrder(Long id, Long userId, Long tripId) {
        final Optional<Order> optionalOrder = orderRepo.findById(id);
        if (optionalOrder.isEmpty())
            throw new IllegalArgumentException("Invalid user ID");

        final Order order = optionalOrder.get();
        if (userId != null &&  userId > 0) order.setUserId(userId);
        if (tripId != null && tripId > 0 ) order.setTripId(tripId);

        orderRepo.save(order);
    }

    // Delete order
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}

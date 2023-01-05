package store.service;

import store.dtos.OrderDto;
import store.dtos.PantDto;
import store.dtos.ShirtDto;
import store.dtos.UserDto;
import store.exceptions.OrderNotFoundException;
import store.exceptions.UserNotFoundException;

import java.util.List;

public interface StoreService {

    UserDto saveUser (UserDto userDto);
    List<UserDto> findAllUsers();
    UserDto findOne (Long id) throws UserNotFoundException;
    void deleteUser (Long id) throws  UserNotFoundException;
    UserDto updateUser (UserDto userDto) throws UserNotFoundException;

    List<OrderDto> findAllOrders();
    OrderDto findOneOrder(Long id) throws OrderNotFoundException;
    OrderDto saveOrder (OrderDto orderDto, Long userId) throws UserNotFoundException;

    void deleteOrder (Long id) throws OrderNotFoundException;

    List<ShirtDto> findAllShirts();
    ShirtDto saveShirt (ShirtDto shirtDto, Integer stock, String size, String colour, Float prize, Long orderId) throws OrderNotFoundException;
    List<PantDto> findAllPants();
    PantDto savePant (Integer stock, String size, String colour, Float prize, Long orderId) throws OrderNotFoundException;
}

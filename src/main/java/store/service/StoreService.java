package store.service;

import store.dtos.OrderDto;
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
    OrderDto saveOrder (OrderDto orderDto);
}

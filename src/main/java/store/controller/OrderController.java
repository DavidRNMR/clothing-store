package store.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.dtos.OrderDto;
import store.exceptions.OrderNotFoundException;
import store.exceptions.UserNotFoundException;
import store.service.StoreService;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    private StoreService service;

    @GetMapping("/findAllOrders")
    public List<OrderDto> findAll (){
        return service.findAllOrders();
    }

    @GetMapping("/findOneOrder/{id}")
    public OrderDto findOneOrder (@PathVariable Long id) throws OrderNotFoundException{
        return service.findOneOrder(id);
    }

    @PostMapping("/addOrder/{userId}")
    public OrderDto saveOrder (@RequestBody OrderDto orderDto,@PathVariable Long userId) throws UserNotFoundException {

        return service.saveOrder(orderDto,userId);
    }

    @DeleteMapping("deleteOrder/{id}")
    public void deleteOrder (@PathVariable Long id) throws OrderNotFoundException{
        service.deleteOrder(id);
    }
}

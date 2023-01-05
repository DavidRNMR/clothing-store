package store.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.dtos.ShirtDto;
import store.exceptions.OrderNotFoundException;
import store.service.StoreService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemController {

    private StoreService service;

    @PostMapping("/addShirt/{orderId}")
    public ShirtDto saveOne(@RequestBody ShirtDto shirtDto, @PathVariable Long orderId) throws OrderNotFoundException {

        this.service.saveShirt(shirtDto,shirtDto.getStock(),shirtDto.getSize(),shirtDto.getColour(),shirtDto.getPrize(),orderId);
        return shirtDto;
    }

    @GetMapping("/findAllShirts")
    public List<ShirtDto> findAll(){
        return service.findAllShirts();
    }
}

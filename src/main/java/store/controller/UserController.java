package store.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.dtos.UserDto;
import store.exceptions.UserNotFoundException;
import store.service.StoreService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private StoreService service;


    @PostMapping("/addUser")
    public UserDto addUser(@RequestBody UserDto userDto){

        return service.saveUser(userDto);
    }

    @GetMapping("/findAllUsers")
    public List<UserDto> findAll(){

        return service.findAllUsers();

    }

    @GetMapping("/findOneUser/{id}")
    public UserDto getOne (@PathVariable Long id) throws UserNotFoundException{

        return service.findOne(id);
    }

    @PutMapping("/updateUser/{id}")
    public UserDto update (@PathVariable Long id, @RequestBody UserDto userDto) throws UserNotFoundException{

        userDto.setId(id);
        return service.updateUser(userDto);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void delete (@PathVariable Long id) throws UserNotFoundException{
         service.deleteUser(id);
    }



}

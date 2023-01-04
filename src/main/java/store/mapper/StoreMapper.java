package store.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import store.dtos.OrderDto;
import store.dtos.PantDto;
import store.dtos.ShirtDto;
import store.dtos.UserDto;
import store.entities.OrderEntity;
import store.entities.PantEntity;
import store.entities.ShirtEntity;
import store.entities.UserEntity;

@Service
public class StoreMapper {

    public UserDto fromUser (UserEntity userEntity){

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity,userDto);

        return userDto;
    }

    public UserEntity fromUserDto (UserDto userDto){

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto,userEntity);

        return userEntity;
    }

    public PantDto fromPant (PantEntity pantEntity){

        PantDto pantDto = new PantDto();
        BeanUtils.copyProperties(pantEntity,pantDto);

        return pantDto;
    }

    public  PantEntity fromPantDto (PantDto pantDto){

        PantEntity pantEntity = new PantEntity();
        BeanUtils.copyProperties(pantDto,pantEntity);

        return pantEntity;
    }

    public ShirtDto fromShirt (ShirtEntity shirtEntity){

        ShirtDto shirtDto = new ShirtDto();
        BeanUtils.copyProperties(shirtEntity,shirtDto);

        return shirtDto;
    }

    public ShirtEntity fromShirtDto (ShirtDto shirtDto){

        ShirtEntity shirtEntity = new ShirtEntity();
        BeanUtils.copyProperties(shirtDto,shirtEntity);

        return shirtEntity;
    }

    public OrderEntity fromOrderDto (OrderDto orderDto){

        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderDto,orderEntity);

        orderEntity.setUser(fromUserDto(orderDto.getUserDto()));

        return orderEntity;
    }


    public OrderDto fromOrder(OrderEntity orderEntity){

        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderEntity,orderDto);

        orderDto.setUserDto(fromUser(orderEntity.getUser()));

        return orderDto;
    }
}

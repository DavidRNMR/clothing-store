package store.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.dtos.OrderDto;
import store.dtos.PantDto;
import store.dtos.ShirtDto;
import store.dtos.UserDto;
import store.entities.OrderEntity;
import store.entities.PantEntity;
import store.entities.ShirtEntity;
import store.entities.UserEntity;
import store.enums.OrderStatus;
import store.enums.StockStatus;
import store.exceptions.OrderNotFoundException;
import store.exceptions.UserNotFoundException;
import store.mapper.StoreMapper;
import store.repositories.OrderRepository;
import store.repositories.PantRepository;
import store.repositories.ShirtRepository;
import store.repositories.UserRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private StoreMapper mapper;
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private ShirtRepository shirtRepository;
    private PantRepository pantRepository;


    @Override
    public UserDto saveUser(UserDto userDto) {

        UserEntity userEntity = mapper.fromUserDto(userDto);
        UserEntity saved = userRepository.save(userEntity);

        return mapper.fromUser(saved);
    }

    @Override
    public List<UserDto> findAllUsers() {

        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities.stream()
                .map(userEntity -> mapper.fromUser(userEntity)).collect(Collectors.toList());
    }

    @Override
    public UserDto findOne(Long id) throws UserNotFoundException {

        UserEntity userEntity = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User Not Found"));

        return mapper.fromUser(userEntity);
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {

        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto) throws UserNotFoundException {

        UserEntity userEntity = mapper.fromUserDto(userDto);
        UserEntity saved = userRepository.save(userEntity);

        return mapper.fromUser(saved);
    }

    @Override
    public List<OrderDto> findAllOrders() {

        List<OrderEntity> orders = orderRepository.findAll();

        return orders.stream().map(orderEntity -> mapper.fromOrder(orderEntity)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOneOrder(Long id) throws OrderNotFoundException {

        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order Not Found"));
        OrderDto orderDto = mapper.fromOrder(orderEntity);

        List<ShirtEntity> shirtEntities = shirtRepository.findAll();
        List<ShirtDto> shirtDtoList = shirtEntities.stream().map(shirtEntity -> mapper.fromShirt(shirtEntity)).toList();

        List<PantEntity> pantEntities = pantRepository.findAll();
        List<PantDto> pantDtoList = pantEntities.stream().map(pantEntity -> mapper.fromPant(pantEntity)).toList();

        orderDto.setPantDtoList(pantDtoList);
        orderDto.setShirtDtoList(shirtDtoList);
        return orderDto;
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto,Long userId) throws UserNotFoundException {

        UserEntity userEntity = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found"));

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreateAt(new Date());
        orderEntity.setUser(userEntity);
        orderEntity.setOrderStatus(OrderStatus.ACTIVE);

        OrderEntity saved = orderRepository.save(orderEntity);

        return mapper.fromOrder(saved);
    }

    @Override
    public void deleteOrder(Long id) throws OrderNotFoundException {
        orderRepository.deleteById(id);
    }

    @Override
    public List<ShirtDto> findAllShirts() {

        List<ShirtEntity> shirtEntities = shirtRepository.findAll();

        return shirtEntities.stream().map(shirtEntity -> mapper.fromShirt(shirtEntity)).collect(Collectors.toList());

    }

    @Override
    public ShirtDto saveShirt(ShirtDto shirtDto, Integer stock, String size, String colour, Float prize, Long orderId) throws OrderNotFoundException {

        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order not found"));

        ShirtEntity shirtEntity = new ShirtEntity();
        shirtEntity.setOrderShirts(orderEntity);
        shirtEntity.setSize(size);
        shirtEntity.setColour(colour);
        shirtEntity.setStock(stock);
        shirtEntity.setPrize(prize);

        if (shirtEntity.getStock()>0){
            shirtEntity.setStockStatus(StockStatus.AVAILABLE);
        }
        else{
            shirtEntity.setStockStatus(StockStatus.SOLDOUT);
        }


        ShirtEntity saved = shirtRepository.save(shirtEntity);

        return mapper.fromShirt(saved);
    }

    @Override
    public List<PantDto> findAllPants() {

        List<PantEntity> pantEntities = pantRepository.findAll();

        return pantEntities.stream().map(pantEntity -> mapper.fromPant(pantEntity)).collect(Collectors.toList());
    }

    @Override
    public PantDto savePant(PantDto pantDto,Integer stock, String size, String colour, Float prize, Long orderId) throws OrderNotFoundException{

        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order Not Found"));

        PantEntity pantEntity = new PantEntity();
        pantEntity.setOrderPants(orderEntity);
        pantEntity.setSize(size);
        pantEntity.setStock(stock);
        pantEntity.setPrize(prize);
        pantEntity.setColour(colour);

        if(pantEntity.getStock()>0){
            pantEntity.setStockStatus(StockStatus.AVAILABLE);
        }
        else{
            pantEntity.setStockStatus(StockStatus.SOLDOUT);
        }

        PantEntity saved = pantRepository.save(pantEntity);

        return mapper.fromPant(saved);
    }
}

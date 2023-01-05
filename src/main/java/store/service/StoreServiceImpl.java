package store.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import store.dtos.OrderDto;
import store.dtos.UserDto;
import store.entities.UserEntity;
import store.exceptions.OrderNotFoundException;
import store.exceptions.UserNotFoundException;
import store.mapper.StoreMapper;
import store.repositories.OrderRepository;
import store.repositories.PantRepository;
import store.repositories.ShirtRepository;
import store.repositories.UserRepository;
import javax.transaction.Transactional;
import java.util.List;
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
        return null;
    }

    @Override
    public OrderDto findOneOrder(Long id) throws OrderNotFoundException {
        return null;
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        return null;
    }
}

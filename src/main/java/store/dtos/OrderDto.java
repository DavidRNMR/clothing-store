package store.dtos;

import lombok.Data;
import store.enums.OrderStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto implements Serializable {

    private Long id;
    private Date createAt;
    private OrderStatus orderStatus;
    private List<ShirtDto> shirtDtoList;
    private List<PantDto> pantDtoList;
    private UserDto userDto;

}

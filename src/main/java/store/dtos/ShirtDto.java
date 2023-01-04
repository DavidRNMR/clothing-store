package store.dtos;

import lombok.Data;
import store.enums.StockStatus;

import java.io.Serializable;

@Data
public class ShirtDto implements Serializable {

    private Long id;
    private String size;
    private Float prize;
    private String colour;
    private StockStatus stockStatus;
}

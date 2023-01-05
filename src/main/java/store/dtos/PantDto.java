package store.dtos;

import lombok.Data;
import store.enums.StockStatus;

import java.io.Serializable;

@Data
public class PantDto implements Serializable {

    private Long id;
    private String size;
    private Float prize;
    private String colour;
    private Integer stock;
    private StockStatus stockStatus;
}

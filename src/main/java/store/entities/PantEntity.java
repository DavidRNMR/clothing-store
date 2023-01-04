package store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.enums.StockStatus;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pants")
public class PantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    private Float prize;
    private String colour;
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    @ManyToOne
    private OrderEntity orderPants;
}

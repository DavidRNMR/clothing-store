package store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "orderShirts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ShirtEntity> shirts;

    @OneToMany(mappedBy = "orderPants",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PantEntity> pants;

}

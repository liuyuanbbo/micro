package zzjjcc.micro.reactor.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STOCK_SUBSCRIPTION")
@Getter
@Setter
public class StockSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String symbol;
}
package zzjjcc.micro.reactor.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STOCK")
@Getter
@Setter
public class Stock {
    @Id
    private String symbol;

    private String name;
}
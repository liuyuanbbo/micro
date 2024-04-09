package zzjjcc.micro.reactor.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zzjjcc.micro.reactor.jpa.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findBySymbol(String symbol);
}

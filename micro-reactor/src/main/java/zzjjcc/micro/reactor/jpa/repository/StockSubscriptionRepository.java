package zzjjcc.micro.reactor.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zzjjcc.micro.reactor.jpa.entity.StockSubscription;

import java.util.List;

public interface StockSubscriptionRepository extends JpaRepository<StockSubscription, Long> {
    List<StockSubscription> findByEmail(String email);

    List<StockSubscription> findByEmailAndSymbol(String email, String symbol);
}

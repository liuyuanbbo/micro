package zzjjcc.micro.reactor.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzjjcc.micro.reactor.jpa.entity.StockSubscription;
import zzjjcc.micro.reactor.jpa.repository.StockSubscriptionRepository;
import zzjjcc.micro.reactor.mvc.service.StockPriceService;
import zzjjcc.micro.reactor.mvc.service.support.PriceQueryEngine;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StockPriceServiceImpl implements StockPriceService {
    private StockSubscriptionRepository subscriptionRepository;

    private PriceQueryEngine priceQueryEngine;

    @Autowired
    public void setSubscriptionRepository(StockSubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Autowired
    public void setPriceQueryEngine(PriceQueryEngine priceQueryEngine) {
        this.priceQueryEngine = priceQueryEngine;
    }

    @Override
    public Map<String, String> getPrice(String email) {
        List<StockSubscription> subscriptions = subscriptionRepository.findByEmail(email);
        return subscriptions.stream()
                .map(StockSubscription::getSymbol)
                .collect(Collectors.toMap(
                                Function.identity(),
                                s -> priceQueryEngine.getPriceForSymbol()
                        )
                );
    }
}

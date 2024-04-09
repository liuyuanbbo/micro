package zzjjcc.micro.reactor.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import zzjjcc.micro.reactor.jpa.entity.Stock;
import zzjjcc.micro.reactor.jpa.entity.StockSubscription;
import zzjjcc.micro.reactor.jpa.repository.StockRepository;
import zzjjcc.micro.reactor.jpa.repository.StockSubscriptionRepository;
import zzjjcc.micro.reactor.mvc.model.StockSubscriptionModel;
import zzjjcc.micro.reactor.mvc.service.SubscriptionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private StockRepository stockRepository;
    private StockSubscriptionRepository subscriptionRepository;

    @Autowired
    public void setSubscriptionRepository(StockSubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Autowired
    public void setStockRepository(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<StockSubscriptionModel> findByEmail(String email) {
        return subscriptionRepository.findByEmail(email)
                .stream()
                .map(stockSubscription ->
                        StockSubscriptionModel.builder()
                                .symbol(stockSubscription.getSymbol())
                                .email(stockSubscription.getEmail())
                                .build()
                ).collect(Collectors.toList());
    }

    @Override
    public void addSubscription(String email, String symbol) {
        checkValidStock(symbol);
        checkSubscriptionExists(email, symbol);
        StockSubscription subscriptionDO = new StockSubscription();
        subscriptionDO.setEmail(email);
        subscriptionDO.setSymbol(symbol);
        subscriptionRepository.save(subscriptionDO);
    }

    private void checkSubscriptionExists(String email, String symbol) {
        List<StockSubscription> matched = subscriptionRepository.findByEmailAndSymbol(email, symbol);
        if (!CollectionUtils.isEmpty(matched)) {
            throw new RuntimeException("subscription already exists for this user");
        }
    }

    private void checkValidStock(String symbol) {
        Optional<Stock> matched = stockRepository.findAll()
                .stream()
                .filter(Stock -> Stock.getSymbol().equalsIgnoreCase(symbol))
                .findAny();
        if (matched.isEmpty()) {
            throw new RuntimeException("stock symbol not valid");
        }
    }
}

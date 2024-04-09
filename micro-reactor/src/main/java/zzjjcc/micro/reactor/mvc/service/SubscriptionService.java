
package zzjjcc.micro.reactor.mvc.service;

import zzjjcc.micro.reactor.mvc.model.StockSubscriptionModel;

import java.util.List;

public interface SubscriptionService {
    List<StockSubscriptionModel> findByEmail(String email);

    void addSubscription(String email, String symbol);
}

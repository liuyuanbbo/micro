package zzjjcc.micro.reactor.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zzjjcc.micro.reactor.mvc.model.StockSubscriptionModel;
import zzjjcc.micro.reactor.mvc.model.StockSymbol;
import zzjjcc.micro.reactor.mvc.service.SubscriptionService;

import java.util.List;

import static zzjjcc.micro.reactor.mvc.Constants.TEST_USER_EMAIL;


@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private SubscriptionService subscriptionServiceImpl;

    @Autowired
    public void setSubscriptionServiceImpl(SubscriptionService subscriptionServiceImpl) {
        this.subscriptionServiceImpl = subscriptionServiceImpl;
    }

    @PostMapping
    public String addSubscription(@ModelAttribute(value = "stockSymbol") StockSymbol symbol) {
        subscriptionServiceImpl.addSubscription(TEST_USER_EMAIL, symbol.getSymbol());
        return "redirect:/subscriptions?added=" + symbol.getSymbol();
    }

    @GetMapping
    public String subscription(Model model) {
        String name = TEST_USER_EMAIL;
        List<StockSubscriptionModel> subscriptions = subscriptionServiceImpl.findByEmail(name);
        model.addAttribute("email", name);
        model.addAttribute("subscriptions", subscriptions);

        return "subscription";
    }

}

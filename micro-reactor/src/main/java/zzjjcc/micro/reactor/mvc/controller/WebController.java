package zzjjcc.micro.reactor.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zzjjcc.micro.reactor.mvc.service.StockPriceService;

import static zzjjcc.micro.reactor.mvc.Constants.TEST_USER_EMAIL;

@Controller
public class WebController {

    private StockPriceService stockPriceServiceImpl;

    @Autowired
    public void setStockPriceServiceImpl(StockPriceService stockPriceServiceImpl) {
        this.stockPriceServiceImpl = stockPriceServiceImpl;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("email", TEST_USER_EMAIL);
        model.addAttribute("stockPrices", stockPriceServiceImpl.getPrice(TEST_USER_EMAIL));
        return "index";
    }
}

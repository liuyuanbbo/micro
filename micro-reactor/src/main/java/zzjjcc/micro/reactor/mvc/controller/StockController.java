package zzjjcc.micro.reactor.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zzjjcc.micro.reactor.mvc.model.StockModel;
import zzjjcc.micro.reactor.mvc.model.StockSymbol;
import zzjjcc.micro.reactor.mvc.service.StockService;

import java.util.List;

@Controller
@RequestMapping("/stocks")
public class StockController {
    private StockService stockServiceImpl;

    @Autowired
    public void setStockServiceImpl(StockService stockServiceImpl) {
        this.stockServiceImpl = stockServiceImpl;
    }

    @GetMapping
    private String getStocks(Model model) {
        List<StockModel> stocks = stockServiceImpl.getAllStocks();
        model.addAttribute("stocks", stocks);
        model.addAttribute("stockSymbol", new StockSymbol());
        return "stocks";
    }
}

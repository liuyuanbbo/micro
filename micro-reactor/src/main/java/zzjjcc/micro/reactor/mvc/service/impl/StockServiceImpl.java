package zzjjcc.micro.reactor.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzjjcc.micro.reactor.jpa.repository.StockRepository;
import zzjjcc.micro.reactor.mvc.model.StockModel;
import zzjjcc.micro.reactor.mvc.service.StockService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {
    private StockRepository stockRepository;

    @Autowired
    public void setStockRepository(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<StockModel> getAllStocks() {
        return stockRepository.findAll()
                .stream()
                .map(stock -> StockModel.builder()
                        .symbol(stock.getSymbol())
                        .name(stock.getName())
                        .build()
                )
                .collect(Collectors.toList());
    }
}

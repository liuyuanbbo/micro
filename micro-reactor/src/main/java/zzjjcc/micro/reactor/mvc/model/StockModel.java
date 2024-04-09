package zzjjcc.micro.reactor.mvc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StockModel {
    private String symbol;
    private String name;
}

package zzjjcc.micro.reactor.mvc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Price {
    private Integer coefficient;
    private Integer exponent;
    private String currency;
}

package zzjjcc.micro.reactor.mvc.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zzjjcc.micro.reactor.mvc.model.StockModel;
import zzjjcc.micro.reactor.mvc.model.User;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @PostMapping("/validate/user/v1")
    public Object validateUserV1(@Valid @RequestBody User user) {
        return "cool";
    }

    @PostMapping("/validate/user/v2")
    public Object validateUserV2(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors();
        } else {
            return "cool";
        }
    }

    @PostMapping("/price")
    public Map<StockModel, String> getPrice() {
        Map<StockModel, String> result = new HashMap<>();
        result.put(StockModel.builder().symbol("APPL").build(), "USD101.00");
        result.put(StockModel.builder().symbol("AMZN").build(), "USD3298.75");
        result.put(StockModel.builder().symbol("TSLA").build(), "USD701.98");
        return result;
    }
}

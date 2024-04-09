package zzjjcc.micro.srva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SrvAApp {
    public static void main(String[] args) {
        SpringApplication.run(SrvAApp.class, args);
    }

}

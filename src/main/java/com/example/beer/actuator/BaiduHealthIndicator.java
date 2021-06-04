package com.example.beer.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class BaiduHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com"))
                .build();
        HttpResponse<String> res = null;
        try {
            res = client.send(req, HttpResponse.BodyHandlers.ofString());
            if (res.statusCode() != 200) {
                return Health.down().withDetail("error", "code is not 200").build();
            }
        } catch (IOException e) {
            return Health.down().withDetail("error", "code is not 200").build();
        } catch (InterruptedException e) {
            return Health.down().withDetail("error", "code is not 200").build();
        }

        return Health.up().withDetail("status",res.statusCode()).build();
    }
}

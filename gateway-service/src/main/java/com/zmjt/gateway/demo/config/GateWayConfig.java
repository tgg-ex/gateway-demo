package com.zmjt.gateway.demo.config;

import com.zmjt.gateway.demo.filter.MyFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyz
 * <p>
 * api方式配置网关
 */
@Configuration
public class GateWayConfig {

    //这个是局部的
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/test/**")
                        .filters(f -> f.filter(new MyFilter())
                                .stripPrefix(1))
                        .uri("lb://CLIENT-SERVICE")
                        .order(0)
                        .id("client-service")
                )
                .build();
    }
}

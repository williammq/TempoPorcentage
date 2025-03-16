package com.pruebaTecnica.tenpo.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        try (RedisConnection connection = connectionFactory.getConnection()) {
            String pingResponse = connection.ping();
            if ("PONG".equals(pingResponse)) {
                System.out.println("✅ Redis is connected successfully!");
            } else {
                System.out.println("❌ Redis connection failed. Ping response: " + pingResponse);
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to connect to Redis: " + e.getMessage());
        }

        // Configuración de la caché con TTL de 30 minutos
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(30));

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .build();
    }
}

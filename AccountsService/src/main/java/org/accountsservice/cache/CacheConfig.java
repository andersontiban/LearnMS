package org.accountsservice.cache;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class CacheConfig {

    @Bean
    public MemcachedClient memcachedClient() throws IOException {
        XMemcachedClientBuilder builder = new XMemcachedClientBuilder("localhost:11211");
        return builder.build();
    }
}

package org.accountsservice.cache;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class CacheService {

    private final MemcachedClient memcachedClient;

    @Autowired
    public CacheService(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    public void setCache(final String key, final Object value, int ttl) throws InterruptedException, TimeoutException, MemcachedException {
        memcachedClient.set(key, ttl, value);
    }

    public Object getCache(final String key) throws InterruptedException, TimeoutException, MemcachedException {
        return memcachedClient.get(key);
    }

}

package org.accountsservice.service;

import net.rubyeye.xmemcached.exception.MemcachedException;
import org.accountsservice.cache.CacheService;
import org.accountsservice.webclient.WebClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeoutException;

@Service
public class AccountService {
    private final WebClientHelper webClientHelper;
    private final CacheService cacheService;

    private final String PETS_URL = "http://PETSERVICE/v1/pets/test";

    @Autowired
    public AccountService(final WebClientHelper webClientHelper, final CacheService cacheService) {
        this.webClientHelper = webClientHelper;
        this.cacheService = cacheService;
    }

    public Mono<String> getDataFromServicePet() throws InterruptedException, TimeoutException, MemcachedException {
        final Mono<String> value = webClientHelper.get(PETS_URL, String.class);

        cacheService.setCache("test1", value.toString(), 9000);

        return value;
    }

    public String test() throws InterruptedException, TimeoutException, MemcachedException {
        Object value = cacheService.getCache("test1");
        return value.toString();
    }

}

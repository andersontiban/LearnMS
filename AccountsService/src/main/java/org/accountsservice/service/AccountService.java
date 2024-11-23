package org.accountsservice.service;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.accountsservice.cache.CacheService;
import org.accountsservice.webclient.WebClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.example.account.Account;

import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class AccountService {
    private final WebClientHelper webClientHelper;
    private final CacheService cacheService;
    private final String PETS_URL = "http://PETSERVICE/v1/pets/test";
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AccountService.class);

    @Autowired
    public AccountService(final WebClientHelper webClientHelper, final CacheService cacheService) {
        this.webClientHelper = webClientHelper;
        this.cacheService = cacheService;
    }

    public Mono<String> getDataFromServicePet() {
        Mono<String> value = null;
        try {
          value = webClientHelper.get(PETS_URL, String.class);
        } catch(Exception e) {
            log.error("Error while trying to get data from Pet Service: " + e.getMessage());
        }
        return value;
    }

    public String test() throws InterruptedException, TimeoutException, MemcachedException {
        Object value = cacheService.getCache("test1");
        return value.toString();
    }

}

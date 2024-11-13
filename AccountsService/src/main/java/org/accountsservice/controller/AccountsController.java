package org.accountsservice.controller;

import net.rubyeye.xmemcached.exception.MemcachedException;
import org.accountsservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/v1/accounts")
public class AccountsController {
    private final AccountService accountService;

    @Autowired
    public AccountsController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/pets")
    public Mono<String> testCommunication() throws InterruptedException, TimeoutException, MemcachedException {
        return accountService.getDataFromServicePet();
    }

    @GetMapping("/cache")
    public String test() throws InterruptedException, TimeoutException, MemcachedException {
        return accountService.test();
    }
}

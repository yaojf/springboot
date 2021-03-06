package com.yaojiafeng.springboot.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author yaojiafeng
 * @create 2018-01-15 上午10:50
 */
@Service
public class RemoteService {

    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 3, backoff = @Backoff(delay = 5000L, multiplier = 1))
    public void call() {
        System.out.println("do something...");
        throw new RemoteAccessException("RPC调用异常");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
    }
}

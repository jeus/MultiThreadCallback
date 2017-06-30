package com.jeus.multiThread.services;

import com.jeus.multiThread.common.CallbackHandler;
import com.jeus.multiThread.entity.SimpleMessage;
import java.util.Random;
import java.util.concurrent.Callable;

public class CallableServices implements Callable<Long> {

    private final int maxDelay = 500000;
    private final int delay;
    private final CallbackHandler callback;

    public CallableServices(CallbackHandler callback) {
        Random ra = new Random();
        delay = ra.nextInt(maxDelay);
        this.callback = callback;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;

        for (int i = 0; i < delay; i++) {
            sum += i;
        }
        SimpleMessage message = (SimpleMessage) callback.getClientData();
        System.out.println("CALLBACK (ID: " + message.getId() + " )");

        if (sum > 2000000) {
            callback.receiveResult(sum);
        } else {
            callback.receiveError(sum);
        }
        return sum;
    }

}

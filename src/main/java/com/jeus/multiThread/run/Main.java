package com.jeus.multiThread.run;

import com.jeus.multiThread.common.Callback;
import com.jeus.multiThread.entity.SimpleMessage;
import com.jeus.multiThread.services.CallableServices;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {

    final int countOfThread = 1000;
    final int countOfTasks = 100000;
    ExecutorService executorService = Executors.newFixedThreadPool(countOfThread);

    public Main() {

        for (int i = 0; i < countOfTasks; i++) {
            SimpleMessage simpleMessage = new SimpleMessage();
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
            System.out.println("SIMPEMESSAGE :(ID: " + simpleMessage.getId() + "  TYPE: " + simpleMessage.getType() + "  DATE: " + dateFormat.format(simpleMessage.getCreateDate()) + " )");
            Callback callback = new Callback(simpleMessage);
            CallableServices callableServices = new CallableServices(callback);

            Future<Long> future = executorService.submit(callableServices);
        }

    }
    
    public static void main(String[] args)
    {
        Main m = new Main();
    }

}

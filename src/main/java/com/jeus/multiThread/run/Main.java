package com.jeus.multiThread.run;

import com.jeus.multiThread.common.Callback;
import com.jeus.multiThread.entity.SimpleMessage;
import com.jeus.multiThread.services.CallableServices;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    final int countOfThread = 1000;
    final int countOfTasks = 100000;
    ExecutorService executorService = Executors.newFixedThreadPool(countOfThread);

    public Main() {
        List<Future<Long>> futures = new ArrayList<>();
        Collection<CallableServices> collectionCallableService = new ArrayList<CallableServices>();
        for (int i = 0; i < countOfTasks; i++) {
            SimpleMessage simpleMessage = new SimpleMessage();
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
            System.out.println("SIMPEMESSAGE :(ID: " + simpleMessage.getId() + "  TYPE: " + simpleMessage.getType() + "  DATE: " + dateFormat.format(simpleMessage.getCreateDate()) + " )");
            Callback callback = new Callback(simpleMessage);
            CallableServices callableServices = new CallableServices(callback);
            collectionCallableService.add(callableServices);
        }

        int i = 0;
        /**non_blocking batch service call*/
        try {
            futures = executorService.invokeAll(collectionCallableService);
            for (Future f : futures) {
                System.out.println(i + " FUTURE: " + f.get());
            i++;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

}

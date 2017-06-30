package com.jeus.multiThread.common;


public class Callback extends CallbackHandler{

    public Callback(Object clientData) {
        super(clientData);
    }

    public Callback() {
    }
    
    @Override
    public void receiveResult(long result) {
        System.out.println("RESULT: "+result);
    }

    @Override
    public void receiveError(long error) {
        System.err.println("ERROR: "+error);
    }
    
    
}

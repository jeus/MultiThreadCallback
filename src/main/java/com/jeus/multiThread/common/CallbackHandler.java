package com.jeus.multiThread.common;

public abstract class CallbackHandler {

    protected Object clientData;

    public CallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    public CallbackHandler() {
        this.clientData = null;
    }
    
    public Object getClientData()
    {
        return clientData;
    }
    
    public abstract void receiveResult(long result);
    
    public abstract void receiveError(long error);

}

package com.iirtech.study.calculatorByStrategy;

public class Debug {
    private static Debug bugInstance;

    public static Debug getInstance(){
        if(bugInstance == null){
            bugInstance = new Debug();
        }
        return bugInstance;
    }

    public boolean debug(){ return false;}
}

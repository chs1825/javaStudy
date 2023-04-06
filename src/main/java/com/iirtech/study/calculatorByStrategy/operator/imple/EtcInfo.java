package com.iirtech.study.calculatorByStrategy.operator.imple;

public class EtcInfo implements Info{

    int priority = 1;

    public EtcInfo() {

    }


    public int getPriority() {
        return priority;
    }

    @Override
    public double execute(double n1, double n2) {
        return 0;
    }
}

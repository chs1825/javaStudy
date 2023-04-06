package com.iirtech.study.calculatorByStrategy.operator.imple;

public class MinusInfo implements Info{

    int priority = 2;
    public MinusInfo(){

    }

    @Override
    public double execute(double n1, double n2) {
        return n1 - n2;
    }

    public int getPriority() {
        return priority;
    }
}

package com.iirtech.study.calculatorByStrategy.operator.imple;

public class PlusInfo implements Info {

    int priority = 2;

    public PlusInfo() {

    }

    @Override
    public double execute(double n1, double n2) {
        return n1 + n2;
    }

    public int getPriority() {
        return priority;
    }
}

package com.iirtech.study.calculatorByStrategy.operator.imple;

public class SquareInfo implements Info {

    int priority = 4;

    @Override
    public double execute(double n1, double n2) {

        return Math.pow(n1, n2);
    }

    public int getPriority() {
        return priority;
    }
}

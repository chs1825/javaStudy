package com.iirtech.study.calculatorByStrategy.operator.imple;

public class DevideInfo implements Info{
    int priority = 3;
    @Override
    public double execute(double n1, double n2) {

        try {
            return n1/ n2;
        }catch (ArithmeticException e){
            e.printStackTrace();
            return n1/ n2;
        }

    }

    public int getPriority() {
        return priority;
    }
}

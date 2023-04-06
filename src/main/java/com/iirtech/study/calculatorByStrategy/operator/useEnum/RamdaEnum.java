package com.iirtech.study.calculatorByStrategy.operator.useEnum;

import java.util.function.BiFunction;

public enum RamdaEnum {

    PLUS("+",2, (num1, num2) -> num1 + num2),
    MINUS("-", 2,(num1, num2) -> num1 - num2),
    MULTIPLY("*", 3, (num1, num2) -> num1 * num2),
    DIVIDE("/", 3, (num1, num2) -> num1 / num2),
    SQUARE("^", 4, (num1, num2) -> Math.pow(num1,num2)),
    ETC1("(", 1, (num1, num2) -> num1 / num2 * 0),
    ETC2(")", 1, (num1, num2) -> num1 / num2 * 0);


    private String operator;
    private int priority;
    private BiFunction<Double, Double, Double> expression;

    RamdaEnum(String operator, int priority, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }

    public double mapCalculate(double num1, double num2) {
        return expression.apply(num1, num2);
    }

    public RamdaEnum find(String op){
        RamdaEnum res = null;
        for (int i = 0; i< RamdaEnum.values().length; i++){
            if(RamdaEnum.values()[i].getOperator().equals(op)){
                res = RamdaEnum.valueOf(RamdaEnum.values()[i].name());
            }
        }
        return res;
    }
}

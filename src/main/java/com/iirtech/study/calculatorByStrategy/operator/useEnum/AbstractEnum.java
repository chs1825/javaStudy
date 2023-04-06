package com.iirtech.study.calculatorByStrategy.operator.useEnum;

public enum AbstractEnum {
    PLUS("+",2){
        @Override
        public double calculate(double n1, double n2) {
            return n1 + n2;
        }
    },
    MINUS("-",2){
        @Override
        public double calculate(double n1, double n2) {
            return n1 - n2;
        }
    },
    MULTIPLY("*",2){
        @Override
        public double calculate(double n1, double n2) {
            return n1 * n2;
        }
    },
    DEVIDE("/",2){
        @Override
        public double calculate(double n1, double n2) {
            return n1 / n2;
        }
    },
    SQUARE("^",2){
        @Override
        public double calculate(double n1, double n2) {
            return Math.pow(n1, n2);
        }
    },
    ETC1("(",1){
        @Override
        public double calculate(double n1, double n2) {
            return 0;
        }
    },
    ETC2(")",1){
        @Override
        public double calculate(double n1, double n2) {
            return 0;
        }
    };



    private final String op;
    private final int priority;

    AbstractEnum(String op, int priority){
        this.op = op;
        this.priority = priority;
    }

    public abstract double calculate(double n1, double n2);




}

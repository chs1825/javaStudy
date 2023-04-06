package com.iirtech.study.calculatorByStrategy;

public class Main {



    public static void main(String[] args) throws Exception {
        Parsing parsing = new Parsing();

        parsing.parse("(5^2+5)+-8/7--3");
//        parsing.parse("(5+-3)");
//        parsing.parse("(-5--3)");
//        parsing.parse("5^2+5+-8/7--3");
//        parsing.parse("+5^2+5+-8----7--3");
//        parsing.parse("+5^2+5+-8--7--3");
//        parsing.parse("+5^2+5-8-7-3");
//        parsing.parse("5^2+5+-8/-7--3");
//        parsing.parse("-5^2+5+-8/-7--3");




    }
}

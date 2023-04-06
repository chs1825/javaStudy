package com.iirtech.study.calculatorByStrategy;

import java.util.List;
import java.util.Stack;

public class PostfixCalculate {

    OperatorMap opMap = new OperatorMap();
    Debug bug = Debug.getInstance();


    public void postfixCal(List<String> list) throws Exception{
        double res = 0;

        Stack<Double> stack = new Stack<Double>();


        int cnt = 0;
        try {
            for(String str : list){
                if(bug.debug())System.out.println(++cnt);
                if(bug.debug())System.out.println("계산시작전 postlist:" + list);
                if(bug.debug())System.out.println("계산시작전 stack:" + stack);
                if(isDouble(str)){
                    stack.push(Double.parseDouble(str));
                    if(bug.debug())System.out.println("stack:" + stack);
                }else{
                    if(stack.isEmpty()){
                        break;
                    }
                    double n1 = stack.pop();
                    double n2 = stack.pop();
                    if(bug.debug())System.out.println("n1:" + n1);
                    if(bug.debug())System.out.println("n2:" + n2);
                    if(bug.debug())System.out.println("str:" + str);

                    double r = opMap.getOpMap().get(str).mapCalculate(n2,n1);
                    if(bug.debug())System.out.println(str+"계산결과:"+r);
                    if(bug.debug())System.out.println("나누기 0 체크:" +Double.isInfinite(r));
                    if(Double.isInfinite(r) == true){
                        System.out.println("0으로 나누기는 불가능합니다.");
                        System.out.println("숫자를 다시 입력해주세요");
                        return;
                    }else{
                        stack.push(r);
                    }
                    if(bug.debug())System.out.println("stack:" + stack);
                }
            }
            if(bug.debug())System.out.println("pop전 stack:" + stack);
            while(stack.size() != 0){
                res += stack.pop();
            }
//            res = stack.pop();
            if(bug.debug())System.out.println("pop stack:" + stack);
            System.out.println("Main.main 계산결과:" + res);
        }catch (Exception e){
            System.out.println("연산자를 잘못 입력하였습니다.");
            System.out.println("다시 입력해주세요");
        }
    }



    public boolean isDouble(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }



}

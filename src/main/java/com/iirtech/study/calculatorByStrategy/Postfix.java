package com.iirtech.study.calculatorByStrategy;

import java.util.List;
import java.util.Stack;

public class Postfix {

    OperatorMap opMap = new OperatorMap();
    Debug bug = Debug.getInstance();

    public void makePostfix(List<String> list) throws Exception {

        List<String> postfix = new Stack<>();  // 후기표기법 식 변환 스택
        Stack<String> operator = new Stack<>(); // 연산자 담는 스택

        for (String str: list){

            if(isDouble(str)){
                postfix.add(str);
            }else{
                if(operator.isEmpty()){
                    operator.push(str);
                    continue;
                }

                if(str.equals("(")){
                    operator.push(str);
                    continue;
                }

                if(str.equals(")")){
                    while(!operator.peek().equals("(")){
                        postfix.add(operator.pop());
                    }
                    operator.pop();
                    continue;
                }

                if(chkPriority(str,operator.peek())){
                    operator.push(str);
                }else{
                    while(!operator.isEmpty()){
                        if(!chkPriority(str,operator.peek())){
                            postfix.add(operator.pop());
                        }else{
                            break;
                        }
                    }

                    operator.push(str);

                }

            }



            //-----------------------
            /*if(isDouble(str) == true){// 실수이면
                postfix.add(str);
            }else if(operator.isEmpty()){  //연산자이면서 스택에 아무것도 없을때
                operator.push(str);
            }else{//연산자 우선순위 비교하여
                if(str.equals("(")){
                    operator.push(str);
                    continue;
                }else if(str.equals(")")){
                    while(!operator.peek().equals("(")){
                        postfix.add(operator.pop());
                    }
                    operator.pop();
                    continue;
                }

                if(chkPriority(str,operator.peek())){
                    operator.push(str);
                }else{
                    while(!operator.isEmpty()){
                        if(!chkPriority(str,operator.peek())){
                            postfix.add(operator.pop());
                        }else{
                            break;
                        }
                    }
                    operator.push(str);
                }
            }*/
            //-----
        }
        if(bug.debug())System.out.println(operator);
        if(bug.debug())System.out.println(operator.size());
        int opSize = operator.size();
        for (int i = 0; i < opSize; i++) {
            postfix.add(operator.pop());
            if(bug.debug())System.out.println("postfix 마지막 넣는중:" + postfix);

        }
        System.out.println("postfix 결과:" + postfix);
        if(bug.debug())System.out.println("opeator 결과:" + operator);

        PostfixCalculate pc = new PostfixCalculate();
        pc.postfixCal(postfix);
    }

    public boolean chkPriority(String op1, String op2){
        boolean chk = false;
        int op1Val = opMap.getOpMap().get(op1).getPriority();
        int op2Val = opMap.getOpMap().get(op2).getPriority();
        if(bug.debug())System.out.println("chk:" + op1Val);
        if(bug.debug())System.out.println("chk:" + op2Val);

        if (op1Val > op2Val){
            chk = true;
        }
        else{
            chk = false;
        }

        return chk;
    }


    //숫자인지 체크
    public boolean isDouble(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}

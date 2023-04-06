package com.iirtech.study.calculatorByStrategy;

import java.util.ArrayList;
import java.util.List;

public class Parsing {

    Debug bug = Debug.getInstance();

    //파싱 하기
    public void parse(String s) throws Exception {

        List<String> sList = new ArrayList<>();
        double answer = 0;

        //1. 공백 제거
        s = s.replaceAll(" ", "");

        //2.파싱하기
        boolean chk = false; // - 부호 처리용 체크값
        String num = ""; // 숫자 담는 그릇

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(bug.debug())System.out.println("i번째:" + i);
            if(bug.debug())System.out.println("c번:" + c);
            if (Character.isDigit(c)) { //해당 문자가 숫자라면 num이라는 문자에 담기
                num += String.valueOf(c);
                chk = false;
                if (i == s.length() - 1) {
                    sList.add(num);
                }
            } else {  // 해당 문자가 숫자가 아닐일때의 조건문

                if(c == '.'){//소수점 처리
                    num += String.valueOf(c);
                    chk = false;
                    continue;
                }

                if (!num.equals("")) {
                    sList.add(num);
                    num="";
                } // - 연속시 계산시 공백 발생 방지 처리 해주는 조건문

                if(sList.size() > 0 && isDouble(sList.get(sList.size()-1)) == false && c =='-'){
                    num += String.valueOf(c);
                    continue;
                }

                if (c == '-' && chk == false ) {// - 연산자 처리
                    if (i == 0) { //첫번째가 혹시나 - 로 시작한다면
                        num += String.valueOf(c);
                        continue;
                    }
                    if(num.equals("") ){
                        num += String.valueOf(c);
                        continue;
                    }
//                    if(i < s.length() -1 && i > 1){
//                        if (num.equals("") && isDouble(sList.get(sList.size()-i+2))) {//바로 앞이 연산자 였다면
//                            num += String.valueOf(c);
//                            continue;
//                        }
//                    }
                    chk = true;
                    sList.add(String.valueOf(c));
                    num = "";
                } else {// - 이외의 연산차 처리
                    if (i == 0 && c != '(') { //첫 문자가 기호라면
                        num += String.valueOf(c);
                        continue;
                    }

                    if(c == '(' || c == ')'){
                        sList.add(String.valueOf(c));
                        num = "";
                        continue;
                    }
                    if(c == '-' && chk == true){ // -가 연산자가 아닌 음수- 일때 처리
                        num += String.valueOf(c);
                        continue;
                    }
                    if(bug.debug())System.out.println("parsing 결과:" + sList);
                    if(bug.debug())System.out.println("sList.size():" + sList.size());

                    if(sList.size() > 0 && isDouble(sList.get(sList.size()-1)) == false &&
                            !sList.get(sList.size()-1).equals("(") && !sList.get(sList.size()-1).equals(")")){
                        System.out.println("연산자를 잘 못 입력하였습니다.");
                        System.out.println("다시 입력해주세요.");
                        return;
                    }

                    if(sList.size() > 0 && isDouble(sList.get(sList.size()-1)) == false &&
                            (sList.get(sList.size()-1).equals("(") || sList.get(sList.size()-1).equals(")"))){
                        num += String.valueOf(c);
                        continue;
                    }

//                    if(sList.size() > 0 && isDouble(sList.get(sList.size()-1)) == true){
//                        if(bug.debug())System.out.println("여기가 작동하나?");
//                        num += String.valueOf(c);
//                        continue;
//                    }
                    if(bug.debug())System.out.println("뭐들어가는지:" + String.valueOf(c));
                    sList.add(String.valueOf(c));
                    num = "";
                }
            }
        }//for문 종료

        System.out.println("parsing 결과:" + sList);
        Postfix pp = new Postfix();
        pp.makePostfix(sList); // 파싱한 리스트 후위표기법 만들기
    }

    //실수인지 문자인지 확인
    public boolean isDouble(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}

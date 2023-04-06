package com.iirtech.study;

import java.util.ArrayList;
import java.util.List;

public class CalculatorCHS {

    //public boolean debug(){}
    // 디버그 처리 레벨링 처리도 가능하다.

    public static void main(String[] args) {
        CalculatorCHS method = new CalculatorCHS();
//        String s = "4+(3*2--4)/2"; //식 입력
        String s = "+5^2+5-8-7-3"; //식 입력
        System.out.println("결과:" + method.work(s));
        System.out.println(10^2);
    }


    public boolean debug(){
        return true;
    }

    //파싱메서드
    public List<String> parse(String s){

        List<String> sList = new ArrayList<>();
        double answer = 0;

        //1. 공백 제거
        s = s.replaceAll(" ","");

        //2.파싱하기
        boolean chk = false; // - 부호 처리용 체크값
        String num = ""; // 숫자 담는 그릇

        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){ //해당 문자가 숫자라면 num이라는 문자에 담기
                num += String.valueOf(c);
                chk = false;
                if(i == s.length()-1){
                    sList.add(num);
                }
            }else{  // 해당 문자가 숫자가 아닐일때의 조건문

                if(c == '.'){//소수점 처리
                    num += String.valueOf(c);
                    chk = false;
                    continue;
                }

                if(!num.equals("")){sList.add(num);} // - 연속시 계산시 공백 발생 방지 처리 해주는 조건문
                num = "";

                if(c == '-' && chk == false){// - 연산자 처리
                    int idx = sList.size() -1;
                    String lastEl = sList.get(idx);
                    if(i == 0 || isDouble(lastEl)){ //첫번째가 혹시나 - 로 시작하거나 앞
                        num += String.valueOf(c);
                        continue;
                    }
//                    if(num.equals("")){
//                        num += String.valueOf(c);
//                        continue;
//                    }
                    chk = true;
                    sList.add(String.valueOf(c));
                }else{// - 이외의 연산차 처리
                    if(c == '-' && chk == true){ // -가 연산자가 아닌 음수- 일때 처리
                        num += String.valueOf(c);
                        continue;
                    }
                    sList.add(String.valueOf(c));
                }
            }
        }//for문 종료
       if(debug())System.out.println("파싱된 리스트 확인:" + sList);
        return sList;
    }

    public boolean isDouble(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    //사칙연산 메소드
    public double calculate(List<String> sList){

        double anwser = 0;
        while(true){ // 곱하기 나누기 처리
            int mIndex = sList.indexOf("*");
            int dIndex = sList.indexOf("/");

            if(mIndex == -1 && dIndex == -1){
                break;
            }

            if(mIndex != -1){
                double res = Double.parseDouble(sList.get(mIndex - 1)) * Double.parseDouble(sList.get(mIndex + 1));
                sList.remove(mIndex-1);
                sList.remove(mIndex-1);
                sList.remove(mIndex-1);
                sList.add(mIndex-1, res+"");
            }else{
                double res = Double.parseDouble(sList.get(dIndex - 1)) / Double.parseDouble(sList.get(dIndex + 1));
                sList.remove(dIndex-1);
                sList.remove(dIndex-1);
                sList.remove(dIndex-1);
                sList.add(dIndex-1, res+"");
            }

        }

        while(true){ // 더하기 빼기 처리
            int plusIndex = sList.indexOf("+");
            int minusIndex = sList.indexOf("-");

            if(plusIndex == -1 && minusIndex == -1){
                break;
            }

            if(plusIndex != -1){
                double res = Double.parseDouble(sList.get(plusIndex - 1)) + Double.parseDouble(sList.get(plusIndex + 1));
                sList.remove(plusIndex-1);
                sList.remove(plusIndex-1);
                sList.remove(plusIndex-1);
                sList.add(plusIndex-1, res+"");
            }else{
                double res = Double.parseDouble(sList.get(minusIndex - 1)) - Double.parseDouble(sList.get(minusIndex + 1));
                sList.remove(minusIndex-1);
                sList.remove(minusIndex-1);
                sList.remove(minusIndex-1);
                sList.add(minusIndex-1, res+"");
            }
        }

        anwser = Double.parseDouble(sList.get(0));

        return anwser;
    }
    //실행
    public double work(String s){
        return calculate(parse(s));
    }

}

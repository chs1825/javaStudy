package com.iirtech.study.programers;

/*문제 설명

        대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
        예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
        제한사항
        문자열 s의 길이 : 50 이하의 자연수
        문자열 s는 알파벳으로만 이루어져 있습니다.*/

public class P07 {

    public static void main(String[] args) {
        P07 method = new P07();
        System.out.println(method.solution("pPP0yY0y"));
    }

    boolean solution(String s) {

        boolean answer = true;

        s = s.toLowerCase();

        if(s.contains("p")  == false && s.contains("y") == false){
            return true;
        }

        int pNum = s.length() - s.replace("p", "").length();
        int yNum = s.length() - s.replace("y", "").length();

        if(pNum != yNum){
            answer = false;
        }else{
            answer = true;
        }

        return answer;
    }


}

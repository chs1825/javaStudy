package com.iirtech.study.programers;
/*
문제 설명
        단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

        재한사항
        s는 길이가 1 이상, 100이하인 스트링입니다.*/

public class P21 {

    public static void main(String[] args) {

        System.out.println(solution("abcde"));

    }


    public static String solution(String s) {
        String answer = "";

        if(s.length() % 2 != 0 ){
            int a = s.length() / 2;
            answer = String.valueOf(s.charAt(a));

        }else {
            int a = s.length() /2;
            answer += String.valueOf(s.charAt(a-1));
            answer += String.valueOf(s.charAt(a));

        }

        return answer;
    }
}

package com.iirtech.study.programers;
/*
3진법 뒤집기
        문제 설명
        자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.*/

public class P32 {
    public int solution(int n) {
        int answer = 0;
        String a = Integer.toString(n,3);
        String reverse = new StringBuilder(a).reverse().toString();
        answer = Integer.parseInt(reverse,3);
        return answer;
    }
}

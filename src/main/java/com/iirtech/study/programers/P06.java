package com.iirtech.study.programers;

import java.util.Arrays;

/*자연수 뒤집어 배열로 만들기
        문제 설명

        자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
        제한 조건
        n은 10,000,000,000이하인 자연수입니다.*/
public class P06 {
    public static void main(String[] args) {

        P06 method = new P06();
        String num = "12345";
        String str[] = num.split("");

        System.out.println(Arrays.toString(str));

        System.out.println(Arrays.toString(method.solution(12345)));
    }
    public int[] solution(long n) {

        String num = Long.toString(n);
        int[] answer = new int[num.length()];
        String str[] = num.split("");
        for(int i = 1; i <= str.length; i++){
            answer[i-1] = Integer.parseInt(str[str.length-i]);
        }
        return answer;
    }
}

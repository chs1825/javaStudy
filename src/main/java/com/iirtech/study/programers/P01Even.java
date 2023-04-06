package com.iirtech.study.programers;

import java.util.Scanner;

public class P01Even {


/*    정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
    제한 조건
    num은 int 범위의 정수입니다.
    0은 짝수입니다.*/

    public static void main(String[] args) {
        P01Even method = new P01Even();
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자입력하시오.");
        int num = sc.nextInt();
        System.out.println("정답은:" +method.solution(num));
    }

    String solution(int num) {
        // 리턴할 값은 메모리를 동적 할당해주세요
        String answer = "";
        if(num % 2 == 0){
            answer = "Even";
        }else {
            answer = "Odd";
        }
        return answer;
    }
}

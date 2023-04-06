package com.iirtech.study.programers;

import java.util.Arrays;

/*
최대공약수와 최소공배수
        문제 설명
        두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
        예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

        제한 사항
        두 수는 1이상 1000000이하의 자연수입니다.*/
public class P30 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2,5)));
    }

    public static int[] solution(int a, int b) {
        int[] answer = new int[2];

        int min = (a < b) ? a : b;
        int max = (a > b) ? a: b;

        int remain = 0;
        while(true){
            remain = max % min;
            if(remain ==0){
                break;
            }
            max = min;
            min = remain;
        }

        answer[0] = min;
        answer[1] = a * b / min;

        return answer;
    }
}

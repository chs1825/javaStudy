package com.iirtech.study.programers;
/*
문제 설명
        array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
        divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

        제한사항
        arr은 자연수를 담은 배열입니다.
        정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
        divisor는 자연수입니다.
        array는 길이 1 이상인 배열입니다.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P16 {

    public static void main(String[] args) {
        int[] intArray = {1,3,5,7,2,4,6,10};
        solution(intArray, 5);
        System.out.println(Arrays.toString(solution(intArray, 5)));

    }


    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int answerLen = 0;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answerLen++;
                list.add(arr[i]);
            }
        }
        if(answerLen > 0){
            answer = new int[answerLen];
        }else{
            answer = new int[1];
            answer[0] =-1;
            return answer;
        }

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

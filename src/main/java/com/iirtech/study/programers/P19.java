package com.iirtech.study.programers;

import java.util.Arrays;
/*
문제 설명
        정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

        제한 조건
        arr은 길이 1 이상인 배열입니다.
        인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.*/

public class P19 {
    public static void main(String[] args) {
        int arr[] = {4,3,2,1};
        int arr2[] = {10};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {
        int[] answer = {};

        int min = arr[0]; //하나의 값을 기준으로 잡음.
        //제일 작은 수를 구한다.
        for(int i=1; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }


        System.out.println(min);
        System.out.println("배열 길이:" + arr.length);

        if(arr.length  == 1){
            System.out.println("길이 1 일때");
            answer = new int[1];
            answer[0] = -1;
        }else{
            System.out.println("길이 1 이상일때");
            answer = new int[arr.length-1];
            int index = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == min){
                    continue;
                }
                answer[index++] = arr[i];
            }
        }

        return answer;
    }
}

package com.iirtech.study.programers;

import java.util.Arrays;

public class P41 {
    public static void main(String[] args) {
        int []arr = {1, 5, 2, 6, 3, 7, 4};
        int [][]commands = {{2, 5, 3},{4,4,1},{1,7,3}};
        Arrays.toString(solution(arr,commands));
//        System.out.println(Arrays.toString(solution(arr,commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i =0; i < commands.length; i++){
            answer[i] = fn(array,commands[i][0],commands[i][1],commands[i][2]);
        }
        return answer;
    }


    public static int fn(int[] arr, int a, int b, int c){
        int[] temp = new int[b - a +1];

        for(int i = 0; i < temp.length; i++ ){
            temp[i] = arr[(a-1)+i];
        }

        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp);

        return temp[c-1];
    }


}



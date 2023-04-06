package com.iirtech.study.programers;

public class P45 {
    public static void main(String[] args) {
        solution(new int[]{1, 3, 4, 6});
    }


    public static String solution(int[] food) {
        String answer = "";

        String s = "";
        for(int i =1; i < food.length; i++){
            int cnt = (food[i] / 2);
            for(int j =0; j < cnt; j++){
                s += String.valueOf(i);
            }
        }
        String sReverse = new StringBuilder(s).reverse().toString();

        answer = s + "0" + sReverse;

        return answer;
    }
}

package com.iirtech.study.programers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
문제 설명
        함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

        제한 조건
        n은 1이상 8000000000 이하인 자연수입니다.*/

public class P10 {
    public static void main(String[] args) {
        P10 method = new P10();
        System.out.println("결과:" + method.solution(123));
    }

    public long solution(long n) {
        long answer = 0;

        String str = Long.toString(n);
        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));

        list.sort(Comparator.reverseOrder());
        String num ="";
        for(int i =0; i< list.size(); i++){
            num += list.get(i);
        }

        answer = Long.parseLong(num);

        return answer;
    }
}

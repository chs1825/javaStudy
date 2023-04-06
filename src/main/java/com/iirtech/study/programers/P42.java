package com.iirtech.study.programers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P42 {
    public static void main(String[] args) {
        solution(new int[]{2,1,3,4,1});
    }
    public static int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i != j){
                    int a = numbers[i] + numbers[j];
                    if(!list.contains(a)){
                        list.add(a);
                    }
                }
            }
        }

        int[] answer = new int[list.size()];
        list.sort(Comparator.naturalOrder());

        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i).intValue();
        }

        return answer;
    }

}

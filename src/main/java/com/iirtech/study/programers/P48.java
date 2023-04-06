package com.iirtech.study.programers;

import java.util.HashMap;
import java.util.Map;

public class P48 {

    public static void main(String[] args) {
        solution(new int[]{1,2,3,4,5});
    }


    public static int solution(int[] nums) {
        int answer = 0;
        int N = nums.length / 2;

        Map<Integer,Integer> map = new HashMap<>();

        for(int a : nums){
            map.put(a,a);
        }

        if(map.size() > N){
            answer = N;
        }else{
            answer = map.size();
        }

        return answer;
    }
}

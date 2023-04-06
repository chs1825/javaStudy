package com.iirtech.study.programers;

import java.util.HashMap;
import java.util.Map;

public class P47 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        String []arr = s.split("");
        Map<String, Integer> map = new HashMap<>();


        for(int i =0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                int a = i - (map.get(arr[i]));
                answer[i] = a;
                map.put(arr[i],i);

            }else{
                map.put(arr[i],i);
                answer[i] = -1;
            }
        }
        return answer;
    }

}

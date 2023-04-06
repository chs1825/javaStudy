package com.iirtech.study.programers;

import java.util.*;

public class P40 {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));


    }

    public static int solution(String s) {
        int answer = 0;

        List<String> sList = new ArrayList<>();
        List<String> ssList = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        String ss = "";
        for(int i =0; i < s.toCharArray().length; i++){
            char c = s.toCharArray()[i];

            if(!Character.isDigit(c)){
                ss = ss + String.valueOf(c);
            }

            if(map.containsKey(ss)){
                sList.add(ss);
                ss = "";
            };

        }

        sList.removeAll(ssList);


        for(String word : sList){
            s = s.replace(word,map.get(word));
        }
        answer = Integer.parseInt(s);

        return answer;
    }

}

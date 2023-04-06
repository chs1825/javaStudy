package com.iirtech.study.programers;

import java.util.ArrayList;
import java.util.List;

public class P50 {

    public int solution(int n) {
        int answer = 1;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 2; i <= n; i++) {

            if (fn(i,list)){
                answer++;
                list.add(i);
            }
        }

        return answer;
    }

    public boolean fn(int num, List<Integer> list){

        for(int a : list){
            if(num % a == 0){
                return false;
            }
        }
        int cnt = 1;
        for(int i = 2; i <= num; i++){
            if(list.contains(i)){
                continue;
            }

            if(num % i == 0){
                cnt ++;
            }
        }

        return cnt == 2 ? true : false;
    }

}

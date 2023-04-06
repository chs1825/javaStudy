package com.iirtech.study.programers;

import java.util.ArrayList;
import java.util.List;

public class P51 {

    public int solution(int n) {
        int answer = 1;

        answer = fn(n);

        return answer;
    }


    public int fn(int num){
        List<Integer> list = new ArrayList<>();
        int anwser = 0;

        for(int i =2; i <=num; i ++){
            int cnt = 0;
            int k = 1;

            while(k <= i){
                for(int l : list){
                    if(i % l ==0){
                        cnt = 3;
                    }
                }
                if (cnt >2) {
                    break;
                }

                if(i % k ==0){
                    cnt++;
                }
                k++;
            }

            if (cnt == 2){
                anwser++;
                list.add(i);
            }
        }





        return anwser;
    }

}

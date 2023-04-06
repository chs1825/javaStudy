package com.iirtech.study.programers;

import java.util.Calendar;
import java.util.Date;

public class P46 {

    public String solution(int a, int b) {
        String answer = "";

        Calendar cal = Calendar.getInstance();
        cal.set(2016,a-1,b);

        Date date = new Date(cal.getTimeInMillis());
        answer = date.toString().substring(0,3).toUpperCase();


        return answer;
    }
}

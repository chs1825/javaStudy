package com.iirtech.study.programers;
/*크기가 작은 부분문자열*/


public class P43 {

    public static void main(String[] args) {
        String s = "1234567";
        System.out.println(solution("3141592","271"));
    }

    public static int solution(String t, String p) {
        int answer = 0;

        int stLen = p.length();
        long stNum = Long.parseLong(p);

        for(int i = 0; i <= t.length() - stLen; i++){
            if(Long.parseLong(t.substring(i,stLen+i)) <= stNum){
                answer++;
            }
        }
        return answer;
    }
}

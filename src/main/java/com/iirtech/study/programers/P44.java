package com.iirtech.study.programers;

public class P44 {

    public static void main(String[] args) {
        solution(2,1,20);
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a){
            int rtrn = (n / a) * b;
            answer += rtrn;
            int have = rtrn + (n % a);
            n = have;
        }

        return answer;
    }
}

package com.iirtech.study.programers;

/*
문제 설명

        임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
        n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
        제한 사항
        n은 1이상, 50000000000000 이하인 양의 정수입니다.
*/


public class P08 {
    public static void main(String[] args) {

        P08 method = new P08();
        System.out.println(method.solution(121));

    }

    public long solution(long n) {
        long answer = 0;
        if(Math.pow((int)Math.sqrt(n),2) == n){
            answer = (long)Math.pow(Math.sqrt(n)+1,2);
        }else{
            answer = -1;
        }

        return answer;
    }

}

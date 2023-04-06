package com.iirtech.study.programers;

/*문제 설명

자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
제한사항
N의 범위 : 100,000,000 이하의 자연수*/

public class P04 {
    public static void main(String[] args) {
        P04 method = new P04();

        System.out.println(method.solution(123));
    }
    public int solution(int n) {

        int length = (int)( Math.log10(n)+1);
        int answer = 0;

        for(int i = length; i >0; i--){
            answer += (int)n/(int)Math.pow(10,i-1);
            n -= ((int)n/(int)Math.pow(10,i-1) * (int)Math.pow(10,i-1));
        }

        return answer;
    }
}

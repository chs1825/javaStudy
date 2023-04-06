package com.iirtech.study.programers;

/*문제 설명
        자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
        답이 항상 존재함은 증명될 수 있습니다.

        제한사항
        3 ≤ n ≤ 1,000,000*/
public class P11 {

    public static void main(String[] args) {
        P11 method = new P11();
        method.solution(10);
    }

    public int solution(int n) {

        int answer = 0;
        if(n % 2 == 0){

            for(int i = 2; i <= (n-1); i++) {
                if((n-1) % i == 0){
                    answer = i;
                    break;
                }
            }
        }else{
            answer = 2;
        }
        System.out.println("answer:"+ answer);
        return answer;
    }
}

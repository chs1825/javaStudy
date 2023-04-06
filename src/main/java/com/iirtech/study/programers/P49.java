package com.iirtech.study.programers;

public class P49 {

    public static void main(String[] args) {
        P49 p = new P49();
//        System.out.println(p.solution(10));
//        System.out.println(fun(10,0));
        System.out.println(11 % 3);
    }

    public int solution(int n) {
        int answer = 0;
        return fun(n, answer);
        //소수인 리스트를 하나씩 추가해서 검사해주는게 좋을듯

    }

    public int fun(int num, int answer) {

        if (num == 2) {
            return answer + 1;
        } else {
            if(num % 2 ==0){
                return fun(num - 1, answer);
            }
            if(num != 3 && num % 3 ==0){
                return fun(num - 1, answer);
            }
            if(num != 5 && num % 5 ==0){
                return fun(num - 1, answer);
            }
            if(num != 7 && num % 7 ==0){
                return fun(num - 1, answer);
            }
            if(num !=11 && num % 11 ==0){
                return fun(num - 1, answer);
            }
            if(num !=13 && num % 13 ==0){
                return fun(num - 1, answer);
            }
            if(num !=17 && num % 17 ==0){
                return fun(num - 1, answer);
            }
            if(num !=19 && num % 19 ==0){
                return fun(num - 1, answer);
            }
            int cnt = 0;
            for (int i = 1; i <= num; i++) {
                if (cnt > 2) {
                    break;
                }
                if (num % i == 0) {
                    cnt++;
                }
            }
            answer += cnt == 2 ? 1 : 0;
            return fun(num - 1, answer);
        }
    }
}

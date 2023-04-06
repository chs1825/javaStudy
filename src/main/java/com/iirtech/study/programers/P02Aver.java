package com.iirtech.study.programers;
/*    문제 설명

        정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
        제한사항
        arr은 길이 1 이상, 100 이하인 배열입니다.
        arr_len은 배열 arr의 길이입니다.
        arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
*/
public class P02Aver {

    public static void main(String[] args) {
        P02Aver method = new P02Aver();
        System.out.println("Hello World");
        int arr[] = {1,2,3,4,5};
        System.out.println("정답은: " + method.solution(arr));

    }

    public double solution(int arr[]) {
        double answer = 0;
        double sum = 0;
        for(int i =0; i<arr.length; i++){
            sum += arr[i];
        }
        answer = sum/arr.length;
        return answer;
    }


}

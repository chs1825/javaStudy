package com.iirtech.study.programers;

/*시저 암호
        문제 설명
        어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
        예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
        문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.*/

public class P35 {

    public static void main(String[] args) {
        solution("aBcdZ", 7);
    }
    /*
    A = 65 Z =90
    a = 97 z =122
    * */


    public static String solution(String s, int n) {
        String answer = "";

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(!Character.isAlphabetic(arr[i])){
                answer += arr[i];
                continue;
            }
            char ch = Character.isLowerCase(arr[i]) ? 'a' : 'A';
            arr[i] = (char)((arr[i] - ch + n) % 26 + ch);
            answer += arr[i];
        }

        return answer;
    }






    public String solution2(String s, int n) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isAlphabetic(arr[i])) {
                continue; // 알파벳이 아니면 건너뜁니다.
            }
            char ch = Character.isLowerCase(arr[i]) ? 'a' : 'A';
            arr[i] = (char) ((arr[i] - ch + n) % 26 + ch);
        }
        return new String(arr);
    }

}
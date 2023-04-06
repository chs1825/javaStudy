package com.iirtech.study.programers;

/*
이상한 문자 만들기
        문제 설명
        문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
        각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.*/

public class P33 {

    public static void main(String[] args) {
        System.out.println(1 % 2);
        String ss = "호호 ABCD DDdd";

        System.out.println(ss);
        solution("abcd ABCD DDdd");
    }

    public static String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder(s);
        StringBuilder resSb = new StringBuilder();

        int cut = 0;
        boolean chk = true;
        while(chk){

            cut = sb.indexOf(" ");
            String str = "";
            if(cut == -1){
                chk = false;
                System.out.println("윙:" + sb);
                str = sb.toString();
            }else{
                str = sb.substring(0,cut);
            }
            for(int i = 0; i < str.length(); i++){
                if( i == 0 || (i % 2) == 0){
                    String ns = String.valueOf(str.charAt(i)).toUpperCase();
                    StringBuilder ss = new StringBuilder(str);
                    ss.setCharAt(i,ns.charAt(0));
                    str = ss.toString();

                }else{
                    String ns = String.valueOf(str.charAt(i)).toLowerCase();
                    StringBuilder ss = new StringBuilder(str);
                    ss.setCharAt(i,ns.charAt(0));
                    str = ss.toString();

                }
            }

            System.out.println("바뀐 str : "+ str);
            if(cut != -1){
                str += " ";
            }

            if(chk){
                sb.delete(0,cut+1);
            }
            resSb.append(str);
        }
        answer = resSb.toString();
        return answer;
    }

}

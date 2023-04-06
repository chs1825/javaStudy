package com.iirtech.study.programers;

import java.util.Arrays;

//비밀지도
public class P38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }


    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] sarr1 = new String[arr1.length];
        String[] sarr2 = new String[arr2.length];

        for(int i =0; i < n; i++){
            String s = "";
            String ss = "";
            String str1 = Integer.toString(arr1[i],2);
            String str2 = Integer.toString(arr2[i],2);
            if(str1.length() != n){
                for(int j = 0; j < n-str1.length(); j++){
                    s += "0";
                }
            }
            if(str2.length() != n){
                for(int j = 0; j < n-str2.length(); j++){
                    ss += "0";
                }
            }
            sarr1[i] = s + str1;
            sarr2[i] = ss + str2;
        }


        for(int i =0; i < n; i ++){
            String str = "";
            for(int j =0; j < n; j++){
                if(sarr1[i].charAt(j) == '1' || sarr2[i].charAt(j) =='1'){
                    str +="#";
                }else{
                    str += " ";
                }
            }
            answer[i] = str;
        }




        return answer;
    }

}

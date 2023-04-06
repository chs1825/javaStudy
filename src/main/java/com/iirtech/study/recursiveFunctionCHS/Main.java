package com.iirtech.study.recursiveFunctionCHS;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        OptionalChange oc = new OptionalChange();
        RenameAll rn = new RenameAll();
        ResetAll rs = new ResetAll();
        Scanner sc = new Scanner(System.in);

        boolean res = false;
        System.out.println("변경을 원하는 폴더 경로를 입려해주세요");
        System.out.println("입력 >>");
        String path = sc.nextLine();
        System.out.println("원하는 기능 선택하시오.");
        System.out.println("1.전체 수정중 표시 삽입     2.하위폴더 상태에 따라 폴더명 변경     3.전체 수정중 표시 제거");
        System.out.println("입력>>>");
        String button = sc.nextLine();

        try {
            switch(button){
                case "1" :
                    res = rn.renameFile(path);
                    break;
                case "2" :
                    res = oc.optionalChange(path);
                    break;
                case "3" :
                    res = rs.reset(path);
                    break;
                default:
                    System.out.println("제대로 다시 입력해주세요");
                    main(args);
                    break;

            }
        }catch (NullPointerException e){
            System.out.println("파일 경로가 없다는데요? 파일경로를 확인해주세요");
            System.out.println();
            main(args);
        }finally {
            if (res){
                System.out.println("파일 및 폴더명이 정상적으로 변경되었습니다.");
                System.out.println("다시 시작하시겠습니까?(1.다시 시작     2.종료)");
                System.out.println("입력 >>");
                String go = sc.nextLine();
                if(go.equals("1")){
                    main(args);
                }else {
                    System.out.println("종료되었습니다.");
                }
            }
        }

    }


}

package com.iirtech.study.recursiveFunctionCHS;

import java.io.File;

public class OptionalChange {


    public boolean optionalChange(String path)throws NullPointerException{

        File folder = new File(path);
        File[] list = folder.listFiles();

        int inNum = 0; //폴더내 파일 및 폴더개수(DS_Store) 제외
        int chkNum = 0; // 수정중으로 시작하지 않는 폴더 및 파일의 개수 (DS_Store) 제외

        for(File f : list){
            if(!f.getName().endsWith("DS_Store")){
                inNum ++;
            }
        }

        for(File f : list){
            if(f.isDirectory()){    // 폴더면 재귀함수
                optionalChange(f.getPath());
            }
        }

        list = folder.listFiles(); // 재귀함수 종료 후 리스트 새로고침

        for(File f : list){
            if(!f.getName().endsWith("DS_Store") && !f.getName().startsWith("(수정중)")){
                chkNum ++;
            }
        }

        if(inNum == chkNum){ // 폴더내 수정중으로 시작하는 파일이나 폴더가 없을때
            String newName = folder.getName().replace("(수정중)","");
            folder.renameTo(new File(folder.getParent(),newName));
        }else{ // 수정중인 파일이 있는데 상위 폴더에 수정중이 안붙어 있을 때
            if(!folder.getName().startsWith("(수정중)")){
                String newFolderName = "(수정중)"+ folder.getName();
                File nf = new File(folder.getParent(),newFolderName);
                folder.renameTo(nf);
            }
        }

        return true;
    }



}

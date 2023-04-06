package com.iirtech.study.recursiveFunctionCHS;

import java.io.File;

public class ResetAll {


    public boolean reset(String path) throws NullPointerException{
        // 폴더 내부의 파일과 폴더들을 변경
        File file = new File(path);

        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){  //폴더일때
                reset(f.getPath());
                if(f.getName().startsWith("(수정중)")){
                    String newFolderName = f.getName().substring(5);
                    newFolderName = newFolderName.replace(" ", "");
                    f.renameTo(new File(f.getParent(),newFolderName));
                }
            }else{ //파일일때
                if(f.getName().startsWith("(수정중)")){
                    String newFileName = f.getName().substring(5);
                    newFileName = newFileName.replace(" ", "");
                    f.renameTo(new File(f.getParent(),newFileName));
                }
            }
        }

        if(file.getName().startsWith("(수정중)")){
            String fName = file.getName().replace("(수정중)","");
            file.renameTo(new File(file.getParent(),fName));
        }

        return true;

    }


}

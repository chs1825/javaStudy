package com.iirtech.study.recursiveFunctionCHS;

import java.io.File;

public class RenameAll {


    public boolean renameFile(String path) throws NullPointerException{

        File file = new File(path);
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){ //폴더일때
                if(f.listFiles().length != 0){
                    renameFile(f.getPath());
                }
                if(!f.getName().startsWith("(수정중)")){
                    String newFolderName = "(수정중)"+ f.getName();
//                    String newFolderName = f.getName().substring(5);
                    f.renameTo(new File(f.getParent(),newFolderName));
                }
            }else{ //파일일때
                if(!f.getName().startsWith("(수정중)")){
                    String newFileName = "(수정중)"+ f.getName();
//                    String newFileName = f.getName().substring(5);
                    f.renameTo(new File(f.getParent(),newFileName));
                }
            }
        }

        if(!file.getName().startsWith("(수정중)")){
            String fName = "(수정중)"+file.getName();
            file.renameTo(new File(file.getParent(),fName));
        }

        return true;
    }
}

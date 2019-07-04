package com.hertz.io;

import java.io.*;

/**
 * @author sunyi,
 * @date 2019/6/12,
 * @time 14:03,
 */
public class Fuxi01 {

    /*
        首先明确IO是对文件的处理，对文件处理就一定会有文件处理的类，也就是FILE类
     */
    public static void main(String[] args) throws IOException {
        //MyFile(new File("/Users/sunyi/Downloads/study/其他/"));
        CopyD(new File("/Users/sunyi/Downloads/study/其他/"), new File("/Users/sunyi/Downloads/study/a/"));
    }


    /**
    * javaIo按照操作的类型可以分为：字节流 InputStream，字符流Reader,writer
    *
    */

    public static void CopyD(File oldfile,File newfile) throws IOException {
        if (oldfile.isDirectory()){
            newfile = new File(newfile.getPath(),oldfile.getName());
        };
        CopyALL(oldfile,newfile);
    }

    private static void CopyALL(File oldfile, File newfile) throws IOException {

        if(oldfile.isFile()&& ! oldfile.isHidden()){

            InPutText(oldfile,newfile);
            System.out.println(1111);
        }else if (oldfile.isDirectory()){
            newfile.mkdirs();

            for (File fi: oldfile.listFiles()) {
                CopyALL(fi,new File(newfile,fi.getName()));

            }
        }


    }

    public static void InPutText(File file,File NewFile) throws IOException {
     InputStream fileInputStream = null ;
     OutputStream out = null;

        try {
            fileInputStream= new FileInputStream(file);
            out= new FileOutputStream(NewFile);

            if(file.isFile()){
                byte[] a = new byte[(int) file.length()];
                int len = 0;
                while(-1 != (len = fileInputStream.read(a))){
                    out.write(a,0,len);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                out.close();
            }
            if (fileInputStream!=null){
                fileInputStream.close();
            }
        }




    }





    public static void MyFile(File file){
        /**
        * 对于File 类，核心是对文件系统信息的读取，包括大量的判断方法，是否是文件，是否可读，是否可写，得到上级目录，文件过滤,创建临时文件等。
        */
        long length = file.length();//得到文件的字节长度。
        boolean hidden = file.isHidden();//文件是否是隐藏文件
        File[] fs = file.listFiles(); //返回该目录下所有的文件夹和文件
        String[] list = file.list();//返回路径下的所有文件，包括隐藏文件,包含目录。
        String[] list1 = file.list(new FilenameFilter() { //文件过滤器
            @Override
            public boolean accept(File dir, String name) {
//                System.out.println(name);//dir是目录
//                System.out.println(dir.getName());//String是文件
//                System.out.println("_________________________");
                return !name.equals("dns日志数据.txt");
            }
        });




        for (String str:list1) {
            System.out.println(str);
        }

    }
}

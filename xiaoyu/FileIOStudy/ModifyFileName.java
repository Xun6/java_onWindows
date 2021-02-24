package xiaoyu.FileIOStudy;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 修改文件名示例
 */
public class ModifyFileName {
    public static void main(String[] args) {
        String realPath = "G:\\local_pic\\172.18.30.55\\1";
//        String folderPath = realPath.substring(0, realPath.lastIndexOf("\\"));
        File file = new File(realPath);
        String dirPath = file.getAbsolutePath(); //目录绝对路径
        int num = 1;
        if (file.isDirectory())
        {
//            List<File> files = Arrays.asList(file.listFiles()); // 获取此目录下的文件列表
            File[] files = file.listFiles();//获取此目录下的文件列表
//            System.out.println(files.toString());
            for (File fileFrom : files) {
                String fromFiledir = fileFrom.getName();//得到单个文件名
                System.out.println(fromFiledir);
                 //判断存在同一后缀名的文件
                if (!fromFiledir.isEmpty()) {
//                    fromFile = fromFile.substring(0, fromFile.lastIndexOf("."));
                    String fromFile = "1-1." + num + ".jpg";
                    String toFileName = realPath + "\\" + fromFile;  // 重命名拼接
                    File toFile = new File(toFileName);
                    if (fileFrom.exists() && !fileFrom.equals(fromFile)) {
                        //开始更名
                        fileFrom.renameTo(toFile);
                        System.out.println("名称修改成功！");
                    }else{
                        System.out.println("更名失败！！！");
                    }
                }
                num++;
                if(num > 2){
                    num = 1;
                }
            }
        }
    }
}

package xiaoyu.FileIOStudy;

import java.io.File;

/**
 * 修改文件名示例
 */
public class ModifyFileName {
    public static void main(String[] args) {
        String realPath = "G:\\local_pic\\172.18.30.55\\1";
//        String folderPath = realPath.substring(0, realPath.lastIndexOf("\\"));
        File file = new File(realPath);
        System.out.println(realPath);
        String dirPath = file.getAbsolutePath(); //目录绝对路径
        System.out.println(dirPath);
        int num = 1;
        if (file.isDirectory())
        {
            File[] files = file.listFiles();//获取此目录下的文件列表
            for (File fileFrom : files) {
                String fromFile = fileFrom.getName();//得到单个文件名
                System.out.println(fromFile);
//                fromFile = fromFile.substring(0,fromFile.lastIndexOf("_"));
//                System.out.println(fromFile);
                // 判断存在同一后缀名的文件
                if (fromFile.endsWith(".jpg")) {
                    fromFile = fromFile.substring(0, fromFile.lastIndexOf("_"));
                    String toFileName = dirPath + "\\" + fromFile + "1-1."+num +".jpg";  // 重命名拼接
                    File toFile = new File(toFileName);
                    if (fileFrom.exists() && !toFile.exists()) {
                        //开始更名
                        fileFrom.renameTo(toFile);
                        System.out.println("名称修改成功！");
                    }else{
                        System.out.println("更名失败！！！");
                    }
                }
                num++;
                if(num == 2){
                    num = 1;
                }
            }
        }
    }
}

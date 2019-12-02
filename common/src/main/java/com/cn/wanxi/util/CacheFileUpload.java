package com.cn.wanxi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;
import static com.cn.wanxi.util.WebTools.returnData;
import java.io.*;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


public class CacheFileUpload {

    @Autowired
    private static Environment environment;

    public static Map<String, Object> cacheFile(MultipartFile filecontent, String filePath)  {
        OutputStream os = null;
        InputStream inputStream = null;
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();

        String suffix=filecontent.getOriginalFilename();
        int suffixLength=suffix.lastIndexOf(".");
        String suffixName=suffix.substring(suffixLength+1,suffix.length());
        String imageName=null;

       String[] interceptName={"jpg","png","jpeg","gif"};
       boolean suffixBool=false;
       for (String interceptNameComparison:interceptName) {
           if(suffixName.equals(interceptNameComparison)){
               suffixBool=true;
               imageName=uuid+"."+suffixName;
               break;
           }

       }
       if(suffixBool) {
           try {

               inputStream = filecontent.getInputStream();
               String path = filePath;
               byte[] bs = new byte[1024];
               int len;
               // 输出的文件流保存到本地文件
               File tempFile = new File(path);
               if (!tempFile.exists()) {
                   tempFile.mkdirs();
               }
               String cv = tempFile.getPath() + File.separator + imageName;
               System.out.println(cv);
               os = new FileOutputStream(cv);

               // 开始读取
               while ((len = inputStream.read(bs)) != -1) {
                   os.write(bs, 0, len);
               }
           } catch (FileNotFoundException e) {
               e.printStackTrace();
               return returnData("图片文件找不到", 0);
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               try {
                   os.close();
                   inputStream.close();

               } catch (IOException e) {
                   e.printStackTrace();

               }

           }
       }else{
           return returnData("文件后缀支持的有 jpg , png , jpeg , gif ",1);
       }
        return returnData(imageName,0);
    }
}

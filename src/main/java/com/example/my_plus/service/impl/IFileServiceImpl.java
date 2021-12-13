package com.example.my_plus.service.impl;

import com.example.my_plus.service.IFileService;
import com.example.my_plus.utils.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Log4j2
public class IFileServiceImpl implements IFileService {

    private static Set<String> imageTypeSet = new HashSet<>();

    //为属性动态赋值`
    @Value("${upload.image.localDirPath}")
    private String localDirPath;// = "G:/Javaworkspace/images";
    @Value("${upload.image.urlPath}")
    private String urlPath; //= "http://image.jt.com";   //定义了虚拟路径的域名
    static{
        imageTypeSet.add(".jpg");
        imageTypeSet.add(".png");
        imageTypeSet.add(".gif");
    }

    @Override
    public R uploadImage(MultipartFile uploadFile) {
        //校验图片的类型    1.利用正则表达式  2.利用几集进行校验
        //1.1 获取图片的名称 abc.jpg
        String fileName = uploadFile.getOriginalFilename();//获取原始文件名
        fileName = fileName.toLowerCase();//将所有的字母都小写
        //1.2 获取图片的类型
        int index = fileName.lastIndexOf(".");
        String fileType = fileName.substring(index);   //.jpg
        if(!imageTypeSet.contains(fileType)){//如果类型不匹配
            return R.failed("类型不匹配");
        }
        //2.如何判断文件是否为恶意程序  文件是否有图片的特有属性
        //2.1将上传的文件的类型利用图片API进行转化,  如果转化不成功则一定不是图片
        try {
            BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
            //2.2校验是否有图片的特有属性 高度/宽度
            int width = bufferedImage.getWidth();
            int heigth = bufferedImage.getHeight();
            //2.3校验宽度和高度是否有值
            if(width== 0||heigth==0 ){
                return R.failed("宽高错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return R.failed(e.getMessage());//返回失败即可
        }
        //3.实现分目录存储
        // 方案一:利用hash之后每隔2-3位截取之后拼接
        // 方案二:以时间为单位进行分割  yyyy/MM/dd
        //3.1利用工具api将时间转化为指定的格式
        String datePath = new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
        //3.2 动态生成文件目录 2部分=根目录+时间目录
        String LocalDir = localDirPath + datePath;
        //3.3 判断目录是否纯在,如果不纯在就创建
        File dirFile = new File(LocalDir);
        if (!dirFile.exists()){
            dirFile.mkdirs(); //如果不存在则创建目录
        }
        //4 防止文件重名,需要自定义文件名称 UUID
        //4.1生成UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //4.2动态生成文件名
        String uuidFileName = uuid + fileType;
        //5 实现文件上传 准备文件路径 目录+文件名称
        String realFilePath = LocalDir + uuidFileName;
        //5.1 封装文件真实对象
        File imageFile = new File(realFilePath);
        //5.2实现文件上传
        try {
            uploadFile.transferTo(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //6. 实现路径拼接
        //检查文件上传业务是否正确
        //图片存储的根目录 G:\Javaworkspace\images\2020\08\05\90065a76326b4a72994583621c5c84fb.jpg
        String url = urlPath + datePath + uuidFileName;
        //String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596623702331&di=b1138fe0361d8b9b7111331ba5b33742&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg";
        return R.ok(url);
    }

}

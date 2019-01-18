package com.guojun.jiao.web;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by guojun.jiao on 2019/1/18.
 */
@Controller
public class UploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(new File("/Users/yp-tc-m-4841/Desktop/yyMMdd1"+file.getOriginalFilename()),file.getBytes());
            return "ok";
        }catch (IOException e){
            e.printStackTrace();
            return "wrong";
        }
    }
}

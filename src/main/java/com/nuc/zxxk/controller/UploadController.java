package com.nuc.zxxk.controller;

import com.nuc.zxxk.enums.ResponseEnum;
import com.nuc.zxxk.utils.QiniuUpload;
import com.nuc.zxxk.vo.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin(origins = "http://localhost:9527", maxAge = 3600)
public class UploadController {
    /**
     * 测试上传图片接口功能
     * */
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
    /**
     * 上传图片功能
     * */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        try {
            String picUrl = QiniuUpload.updateFile(file);
            //将图片url保存到数据库,前端请求查数据库返回url
            return picUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败！"+e.getMessage();
        }
    }
}

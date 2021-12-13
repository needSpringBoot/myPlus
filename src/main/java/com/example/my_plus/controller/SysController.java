package com.example.my_plus.controller;

import com.example.my_plus.service.IFileService;
import com.example.my_plus.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sys")
@Api("系统")
public class SysController {

    @Autowired
    private IFileService fileService;

    @PostMapping("/uploadImage")
    public R uploadImage(@RequestPart("file")MultipartFile file){
        return fileService.uploadImage(file);
    }

}

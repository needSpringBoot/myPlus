package com.example.my_plus.service;

import com.example.my_plus.utils.R;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    R uploadImage(MultipartFile uploadFile);
}

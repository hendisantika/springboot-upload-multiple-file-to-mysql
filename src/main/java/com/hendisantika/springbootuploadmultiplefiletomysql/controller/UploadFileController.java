package com.hendisantika.springbootuploadmultiplefiletomysql.controller;

import com.hendisantika.springbootuploadmultiplefiletomysql.model.FileModel;
import com.hendisantika.springbootuploadmultiplefiletomysql.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-upload-multiple-file-to-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/11/18
 * Time: 06.20
 */
@Controller
public class UploadFileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/")
    public String index() {
        return "uploadform";
    }

    @PostMapping("/")
    public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model model) {
        List<String> fileNames = new ArrayList<String>();

        try {
            List<FileModel> storedFile = new ArrayList<FileModel>();

            for (MultipartFile file : files) {
                FileModel fileModel = fileRepository.findByName(file.getOriginalFilename());
                if (fileModel != null) {
                    // update new contents
                    fileModel.setPic(file.getBytes());
                } else {
                    fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
                }

                fileNames.add(file.getOriginalFilename());
                storedFile.add(fileModel);
            }

            // Save all Files to database
            fileRepository.saveAll(storedFile);

            model.addAttribute("message", "Files uploaded successfully!");
            model.addAttribute("files", fileNames);
        } catch (Exception e) {
            model.addAttribute("message", "Fail!");
            model.addAttribute("files", fileNames);
        }

        return "uploadform";
    }
}

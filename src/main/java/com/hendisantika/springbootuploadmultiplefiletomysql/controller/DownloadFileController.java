package com.hendisantika.springbootuploadmultiplefiletomysql.controller;

import com.hendisantika.springbootuploadmultiplefiletomysql.model.FileInfo;
import com.hendisantika.springbootuploadmultiplefiletomysql.model.FileModel;
import com.hendisantika.springbootuploadmultiplefiletomysql.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

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
public class DownloadFileController {

    @Autowired
    FileRepository fileRepository;

    /*
     * Retrieve Files' Information
     */
    @GetMapping("/files")
    public String getListFiles(Model model) {
        List<FileInfo> fileInfos = fileRepository.findAll().stream().map(
                fileModel -> {
                    String filename = fileModel.getName();
                    String url = MvcUriComponentsBuilder.fromMethodName(DownloadFileController.class,
                            "downloadFile", fileModel.getName()).build().toString();
                    return new FileInfo(filename, url);
                }
        )
                .collect(Collectors.toList());

        model.addAttribute("files", fileInfos);
        return "listfiles";
    }

    /*
     * Download Files
     */
    @GetMapping("/files/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
        FileModel file = fileRepository.findByName(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getPic());
    }
}
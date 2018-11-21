package com.hendisantika.springbootuploadmultiplefiletomysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-upload-multiple-file-to-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/11/18
 * Time: 06.16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    private String filename;
    private String url;
}

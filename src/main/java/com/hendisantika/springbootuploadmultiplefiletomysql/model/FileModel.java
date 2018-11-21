package com.hendisantika.springbootuploadmultiplefiletomysql.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-upload-multiple-file-to-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/11/18
 * Time: 06.17
 */
@Entity
@Table(name = "file_model")
@Data
public class FileModel extends DateAudit {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mimetype")
    private String mimetype;

    @Lob
    @Column(name = "pic")
    private byte[] pic;

    public FileModel() {
    }

    public FileModel(String name, String mimetype, byte[] pic) {
        this.name = name;
        this.mimetype = mimetype;
        this.pic = pic;
    }
}
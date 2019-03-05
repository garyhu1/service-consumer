package com.garyhu.pojo;

import java.util.Date;

/**
 * @author: garyhu
 * @since: 2019/3/5 0005
 * @decription:
 */
public class Book {
    private String name;
    private String message;
    private Date postDate;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

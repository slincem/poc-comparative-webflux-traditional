package co.com.personal.traditionalfilessaver.model;

import lombok.Data;

@Data
public class FileContent {

    private String name;
    private String year;
    private Long quantity;
    private Double weight;
    private String content;
    private String notes;

}

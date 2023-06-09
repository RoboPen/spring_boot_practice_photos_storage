package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Table("PHOTOS")
public class Photo {
    @Id
    private Integer id;
    @NotNull
    private String fileName;
    @NotNull
    private String contentType;
    @NotNull
    private Category category;
    @JsonIgnore
    private byte[] data;
    private LocalDateTime dateCreated;

    public Photo() {
    }

    public Photo(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return Objects.equals(getFileName(), photo.getFileName())
                && Objects.equals(getContentType(), photo.getContentType())
                && getCategory() == photo.getCategory() && Arrays.equals(getData(), photo.getData())
                && Objects.equals(getDateCreated(), photo.getDateCreated());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getFileName(), getContentType(), getCategory(), getDateCreated());
        result = 31 * result + Arrays.hashCode(getData());
        return result;
    }
}

package com.example.db.dto;

import java.util.List;

public class PaginationDto {
    private List content;
    private long totalElements;
    private int totalPages;

    public PaginationDto() {
    }

    public PaginationDto(List content, long totalElements, int totalPages) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}

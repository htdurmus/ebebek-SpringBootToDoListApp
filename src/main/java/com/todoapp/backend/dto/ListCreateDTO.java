package com.todoapp.backend.dto;

import lombok.Data;

@Data
public class ListCreateDTO {

    private String task;

    private boolean checked = false;

    private String finishDate;

    private String listName;

}

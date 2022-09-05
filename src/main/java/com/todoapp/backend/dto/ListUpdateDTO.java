package com.todoapp.backend.dto;

import lombok.Data;

@Data
public class ListUpdateDTO {

    private String task;

    private boolean checked;

    private String finishDate;

    private String listName;

}

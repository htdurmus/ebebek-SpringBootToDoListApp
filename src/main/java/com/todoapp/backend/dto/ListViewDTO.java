package com.todoapp.backend.dto;

import com.todoapp.backend.entity.Liste;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ListViewDTO implements Serializable {

    private final Long Id;
    private final String task;
    private final boolean checked;
    private final String finishDate;
    private final String listName;
    public ListViewDTO(Long id, String task, boolean checked, String finishDate, String listName) {
        Id = id;
        this.task = task;
        this.checked = checked;
        this.finishDate = finishDate;
        this.listName = listName;
    }
    public static ListViewDTO of(Liste liste){
        return new ListViewDTO(liste.getId(), liste.getTask(), liste.isChecked(), liste.getFinishDate(), liste.getListName());
    }
}

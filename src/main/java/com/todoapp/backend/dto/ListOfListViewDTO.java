package com.todoapp.backend.dto;

import com.todoapp.backend.entity.Liste;
import lombok.Getter;

@Getter
public class ListOfListViewDTO {

    private final String listName;

    public ListOfListViewDTO(String listName) {
        this.listName = listName;
    }

    public static ListOfListViewDTO of(Liste liste){
        return new ListOfListViewDTO(liste.getListName());
    }
}

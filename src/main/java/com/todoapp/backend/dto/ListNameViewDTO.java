package com.todoapp.backend.dto;

import com.todoapp.backend.entity.Liste;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ListNameViewDTO implements Serializable {

    private final String listName;

    public ListNameViewDTO(String listName) {
        this.listName = listName;
    }

    public static ListNameViewDTO of(Liste liste){
        return new ListNameViewDTO(liste.getListName());
    }
}

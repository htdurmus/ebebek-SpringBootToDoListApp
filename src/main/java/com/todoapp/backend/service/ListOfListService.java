package com.todoapp.backend.service;

import com.todoapp.backend.dto.ListOfListViewDTO;

public interface ListOfListService {

    ListOfListViewDTO getListOfListByName(String listName);

}

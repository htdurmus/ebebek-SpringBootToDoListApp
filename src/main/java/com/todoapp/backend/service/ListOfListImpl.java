package com.todoapp.backend.service;

import com.todoapp.backend.dto.ListOfListViewDTO;
import com.todoapp.backend.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListOfListImpl implements ListOfListService{


    private final ListRepository listRepository;

    @Override
    public ListOfListViewDTO getListOfListByName(String listName) {

        return null;
    }
}

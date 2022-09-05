package com.todoapp.backend.service;

import com.todoapp.backend.dto.ListCreateDTO;
import com.todoapp.backend.dto.ListUpdateDTO;
import com.todoapp.backend.dto.ListViewDTO;

import java.util.List;

public interface ListService {

    ListViewDTO getListById(long id);

    List<ListViewDTO> getLists();

    ListViewDTO createList(ListCreateDTO listViewDTO);

    ListViewDTO updateList(Long id, ListUpdateDTO listUpdateDTO);

    void deleteList(Long id);

    ListViewDTO getListeByName(String name);

}

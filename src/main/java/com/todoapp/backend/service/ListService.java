package com.todoapp.backend.service;

import com.todoapp.backend.dto.ListCreateDTO;
import com.todoapp.backend.dto.ListNameViewDTO;
import com.todoapp.backend.dto.ListUpdateDTO;
import com.todoapp.backend.dto.ListViewDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ListService {

    ListViewDTO getListById(long id);
    List<ListViewDTO> getLists();
    List<ListNameViewDTO> getListNames();
    ListViewDTO createList(ListCreateDTO listViewDTO);
    ListViewDTO updateList(Long id, ListUpdateDTO listUpdateDTO);
    ListViewDTO updateChecked(Long id, ListUpdateDTO listUpdateDTO);
    void deleteList(Long id);
}

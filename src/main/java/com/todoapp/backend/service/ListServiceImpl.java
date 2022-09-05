package com.todoapp.backend.service;


import com.todoapp.backend.dto.ListCreateDTO;
import com.todoapp.backend.dto.ListUpdateDTO;
import com.todoapp.backend.dto.ListViewDTO;
import com.todoapp.backend.entity.Liste;
import com.todoapp.backend.exception.NotFoundSayfasi;
import com.todoapp.backend.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService{

    private final ListRepository listRepository;


    @Override
    public ListViewDTO getListById(long id) {
        final Liste liste = listRepository.findById(id).orElseThrow(() -> new NotFoundSayfasi("Görev bulunamadı..."));
        return ListViewDTO.of(liste);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public java.util.List<ListViewDTO> getLists() {
        return listRepository.findAll().stream().map(ListViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ListViewDTO createList(ListCreateDTO listCreateDTO) {
        final Liste liste = listRepository.save(new Liste(listCreateDTO.getTask(), listCreateDTO.isChecked(), listCreateDTO.getFinishDate(), listCreateDTO.getListName()));
        return ListViewDTO.of(liste);
    }

    @Override
    @Transactional
    public ListViewDTO updateList(Long id, ListUpdateDTO listUpdateDTO) {
        final Liste liste = listRepository.findById(id).orElseThrow(() -> new NotFoundSayfasi("Hata!"));

        liste.setTask(listUpdateDTO.getTask());
        liste.setChecked(listUpdateDTO.isChecked());
        liste.setFinishDate(listUpdateDTO.getFinishDate());
        liste.setListName(listUpdateDTO.getListName());

        final Liste updateListe = listRepository.save(liste);

        return ListViewDTO.of(updateListe);
    }

    @Override
    @Transactional
    public void deleteList(Long id) {
        final Liste liste = listRepository.findById(id).orElseThrow(() -> new NotFoundSayfasi("Görev bulunamadı!"));
        listRepository.deleteById(liste.getId());
    }

    @Override
    public ListViewDTO getListeByName(String name) {
        return null;
    }
}

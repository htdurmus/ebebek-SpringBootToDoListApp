package com.todoapp.backend.controller;

import com.todoapp.backend.dto.ListCreateDTO;
import com.todoapp.backend.dto.ListUpdateDTO;
import com.todoapp.backend.dto.ListViewDTO;
import com.todoapp.backend.service.ListOfListService;
import com.todoapp.backend.service.ListService;
import com.todoapp.backend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/todo")
@RequiredArgsConstructor
public class ListController {

    private  final ListService listService;
    private final ListOfListService listOfListService;

    @GetMapping(path = "/list={id}")
    public ResponseEntity<ListViewDTO> getListById(@PathVariable Long id){
        final ListViewDTO list = listService.getListById(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ListViewDTO>> getLists(){
        final List<ListViewDTO> lists = listService.getLists();
        return ResponseEntity.ok(lists);
    }

    @PostMapping(path = "/newTask")
    public ResponseEntity<?> createTask(@RequestBody ListCreateDTO listCreateDTO){
        listService.createList(listCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Yeni görev oluşturuldu"));
    }

    @PutMapping(path = "/updateTask={id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Long id, @RequestBody ListUpdateDTO listUpdateDTO){
        final ListViewDTO list = listService.updateList(id, listUpdateDTO);
        return ResponseEntity.ok(new GenericResponse(id.toString()+" numaralı görev güncellendi..."));
    }

    @DeleteMapping(path = "/deleteTask={id}")
    public ResponseEntity<?> deleteTas(@PathVariable("id") Long id){
        listService.deleteList(id);
        return ResponseEntity.ok(new GenericResponse(id.toString()+" numaralı görev silindi..."));
    }
}

package com.example.demotodolist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CRUDController {

    public CRUDService crudService;

    public CRUDController(CRUDService crudService){
        this.crudService = crudService;
    }

    @PostMapping("/createTask")
    public String createTask(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return crudService.createTask(crud);
    }

    @GetMapping("/")
    public CRUD getTask(@RequestParam String document_id) throws InterruptedException, ExecutionException {
        return crudService.getTask(document_id);
    }

    @PutMapping("/updateTask")
    public String updateTask(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return crudService.updateTask(crud);
    }

    @DeleteMapping("/")
    public String deleteTask(@RequestBody String document_id) throws InterruptedException, ExecutionException {
        return crudService.deleteTask(document_id);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndPoint(){
        return ResponseEntity.ok("endpoint is working");
    }
}

package com.inetz.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetz.taskmanager.entity.TaskEntity;
import com.inetz.taskmanager.request.TaskRequest;
import com.inetz.taskmanager.service.TaskService;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

	@Autowired
	private TaskService service;
	
	@PostMapping("/create")
	public ResponseEntity<TaskEntity> create(@RequestBody TaskRequest ref)
	{
		TaskEntity response=service.create(ref);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<TaskEntity>> get()
	{
		List<TaskEntity> response=service.get();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TaskEntity> getbyid(@PathVariable("id") Integer id)
	{
		TaskEntity response=service.getbyid(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TaskEntity> update(@RequestBody TaskRequest ref)
	{
		TaskEntity response=service.update(ref);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PatchMapping("/change/{id}")
	public ResponseEntity<TaskEntity> change(
	        @PathVariable Integer id,
	        @RequestBody TaskRequest ref) {

	    TaskEntity response = service.change(id, ref);
	    return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		service.delete(id);
		return new ResponseEntity<>("this task deleted",HttpStatus.OK);
	}
}

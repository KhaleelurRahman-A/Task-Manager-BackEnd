package com.inetz.taskmanager.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inetz.taskmanager.entity.TaskEntity;
import com.inetz.taskmanager.repository.TaskRepository;
import com.inetz.taskmanager.request.TaskRequest;
import com.inetz.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;
	
	@Override
	public TaskEntity create(TaskRequest ref) {
		TaskEntity stf=new TaskEntity();
		stf.setTitle(ref.getTitle());
		stf.setDescription(ref.getDescription());
		stf.setPriority(ref.getPriority());
		stf.setCreated_date(LocalDate.now());
		stf.setCompleted(false);
		
		return repository.save(stf);	
	}

	@Override
	public List<TaskEntity> get() {
		return repository.findAll();
	}

	@Override
	public TaskEntity getbyid(Integer id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("No Tasks Found"));

	}

	@Override
	public TaskEntity update(TaskRequest ref) {
		TaskEntity task=repository.findById(ref.getId()).orElseThrow(() -> new RuntimeException("task not found"));
		 task.setTitle(ref.getTitle());
		    task.setDescription(ref.getDescription());
		    task.setPriority(ref.getPriority());
		    task.setCompleted(ref.getCompleted());
           return repository.save(task);
	}
	
	@Override
	public void delete(Integer id) {
		TaskEntity task = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Task not found"));

	    repository.delete(task);		
	}

	@Override
	public TaskEntity change(Integer id, TaskRequest ref) {
		
		TaskEntity task=repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Task not found"));
		task.setCompleted(ref.getCompleted());
		return repository.save(task);
	}
}

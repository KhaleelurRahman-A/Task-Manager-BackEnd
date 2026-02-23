package com.inetz.taskmanager.service;

import java.util.List;

import com.inetz.taskmanager.entity.TaskEntity;
import com.inetz.taskmanager.request.TaskRequest;

public interface TaskService {

	TaskEntity create(TaskRequest ref);

	List<TaskEntity> get();

	TaskEntity getbyid(Integer id);

	TaskEntity update(TaskRequest ref);

	void delete(Integer id);

	TaskEntity change(Integer id, TaskRequest ref);

}

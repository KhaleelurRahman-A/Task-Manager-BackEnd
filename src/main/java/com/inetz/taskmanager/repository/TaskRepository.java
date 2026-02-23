package com.inetz.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inetz.taskmanager.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {

}

package com.example.EM_testcase.model.repository;

import com.example.EM_testcase.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findAllTasksByAuthor(String author, Pageable pageable);
    Page<Task> findAllTasksByExecutor(String executor, Pageable pageable);
}

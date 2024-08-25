package com.example.EM_testcase.model.repository;

import com.example.EM_testcase.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Page<Task>> findAllTasksByAuthor(String author, Pageable pageable);
    Optional<Page<Task>> findAllTasksByExecutor(String executor, Pageable pageable);
    boolean existsByHeaderAndAuthorAndExecutor(String header, String author, String executor);
}

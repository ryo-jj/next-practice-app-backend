package com.springboot.test.next_practice_app_backend.service;

import com.springboot.test.next_practice_app_backend.entity.Tasks;
import com.springboot.test.next_practice_app_backend.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;

    public List<Tasks> findAll() {
        return tasksRepository.findAll();
    }
}

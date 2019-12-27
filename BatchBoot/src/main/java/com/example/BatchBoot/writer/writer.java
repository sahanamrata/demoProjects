package com.example.BatchBoot.writer;

import com.example.BatchBoot.model.User;
import com.example.BatchBoot.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class writer implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void write(List<? extends User> list) throws Exception {
        userRepository.saveAll(list);
    }
}

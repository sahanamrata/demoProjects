package com.example.BatchBoot.processor;

import com.example.BatchBoot.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class Processor implements ItemProcessor<User,User> {
    private static final Map<String , String > dept_ids = new HashMap<>();

    public Processor() {
        dept_ids.put("001", "Accounts");
        dept_ids.put("002", "Finance");
        dept_ids.put("003","IT");

    }

    @Override
    public User process(User user) throws Exception {

        String ids = user.getDept();
        String dept_names = dept_ids.get(ids);
        user.setDept(dept_names);
        user.setTime(new Date());

        return user;
    }
}

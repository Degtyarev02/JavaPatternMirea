package com.example.EX18.Service;

import com.example.EX18.Entity.Post;
import com.example.EX18.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class SchedulerServiceImpl {

    @Autowired
    com.example.EX18.Service.Service service;

    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() {
        File folder = new File("/home/vladimir/Downloads/JavaPatternMirea/EX18/src/main/java/org/example/EX18/ScheduledFile");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }

        File userFile = new File("/home/vladimir/Downloads/JavaPatternMirea/EX18/src/main/java/com/example/EX18/ScheduledFile/user.txt");
        if(!userFile.exists()){
            try {
                userFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File postFile = new File("/home/vladimir/Downloads/JavaPatternMirea/EX18/src/main/java/com/example/EX18/ScheduledFile/post.txt");
        if(!postFile.exists()){
            try {
                postFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter userWriter;
        FileWriter postWriter;

        try {
            userWriter = new FileWriter(userFile.getAbsolutePath(), false);
            List<User> users = service.getUsers();
            for (User u : users) {
                userWriter.append(u.toString());
                userWriter.append("\n");
            }
            userWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            postWriter = new FileWriter(postFile.getAbsolutePath(), false);
            List<Post> posts = service.getPosts();
            for (Post u : posts) {
                postWriter.append(u.toString());
                postWriter.append("\n");
            }
            postWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

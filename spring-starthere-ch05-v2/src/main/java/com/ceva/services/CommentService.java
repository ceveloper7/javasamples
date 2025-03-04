package com.ceva.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy // le decimos a spring que necesita crear el bean solo cuando alguien hace referencia al bean por primera vez
public class CommentService {
    public CommentService(){
        System.out.println("CommentService instance created");
    }
}

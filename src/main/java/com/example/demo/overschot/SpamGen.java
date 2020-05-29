package com.example.demo.overschot;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class SpamGen implements SpamInt {
    String spam;


    public SpamGen() {
    }


    public String getSpam() {
        spam = new Random().doubles().toString();
        return spam;
    }
}

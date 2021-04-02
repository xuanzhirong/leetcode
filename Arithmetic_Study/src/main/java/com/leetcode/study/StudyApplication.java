package com.leetcode.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap();
        SpringApplication.run(StudyApplication.class, args);
    }

}

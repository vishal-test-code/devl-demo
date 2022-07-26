package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		
		String ta = "A";
		 ta = ta.concat("B");
		 String tb = "D";
		 ta = ta.concat(tb);
		 ta.replace("C", "D");
		 ta = ta.concat(tb);
		 System.out.println(ta);
	}

}

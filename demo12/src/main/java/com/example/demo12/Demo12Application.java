package com.example.demo12;

import com.example.demo12.ThreadingExample.*;
import com.example.demo12.pdfCreater.PdfCreaterExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo12Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo12Application.class, args);

//		ArrayListExample.printArrayList();
		/*Cat c = new Cat();
		c.jump();
		c.eat();
		Animal animal = new Cat();
		animal.eat();
		Dog dog = new Dog();
		dog.bark();
		dog.eat();*/

		/*// Using Thread
		MultiThread1 multiThread1=new MultiThread1();
		multiThread1.start();

		// Using Runnable Interface
		MultiThread2 multiThread2=new MultiThread2();
		Thread t1=new Thread(multiThread2);
		t1.start();
		System.out.println("Thread Name is: "+t1.getName());*/

       /* Table tt = new Table();
        TableThread1 tb = new TableThread1(tt);
        tb.start();*/

        PdfCreaterExample pd = new PdfCreaterExample();
        pd.pdfWork();
    }

}

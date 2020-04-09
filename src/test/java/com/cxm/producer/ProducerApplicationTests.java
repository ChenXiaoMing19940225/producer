package com.cxm.producer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@SpringBootTest
class ProducerApplicationTests {
	//队列大小
	public static  final int TASK_LIST_SIZE=2000;

	@Test
	void contextLoads() {
	}
   public static void main(String args[]){
	   BlockingQueue<Map> quenu = new ArrayBlockingQueue<Map>(TASK_LIST_SIZE);

   }
}

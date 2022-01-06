package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void addNewComments(){
		ThreadRepository threadRepository = new ThreadRepository();

		Assertions.assertEquals(4, threadRepository.getThread("Politics").getNumOfComments());//check start number of comments

		threadRepository.getThread("Politics").setComments("Just an other pointless comment to fill the void!");
		Assertions.assertEquals(5, threadRepository.getThread("Politics").getNumOfComments());//check number of comments
		Assertions.assertEquals("Just an other pointless comment to fill the void!", threadRepository.getThread("Politics").getSpecificComment(4)); //check newly wrote comment

	}

	@Test
	void contextLoads() {
	}

}

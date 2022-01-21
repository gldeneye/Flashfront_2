package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public ThreadRepository threadRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetThreads() {
		List<Thread> threads = threadRepository.getAllThreads();
		Assertions.assertEquals(8, threads.size());
	}

	@Test
	public void testGetThreadByName() {
		Thread t = threadRepository.getThreadByName("Politics");
		Assertions.assertEquals("Politics", t.getName());
	}

	@Test
	public void testGetThreadById() {
		Thread t = threadRepository.getThreadById(1);
		Assertions.assertEquals("Politics", t.getName());
	}

	@Test
	public void testGetCommentsByThread() {
		List<Comments> c = threadRepository.listComments(1);
		Assertions.assertEquals(2,c.size());
	}


//	@Test
//	void addNewComments(){
//		ThreadRepository threadRepository = new ThreadRepository();
//
//		Assertions.assertEquals(4, threadRepository.getThread("Politics").getNumOfComments());//check start number of comments
//
//		threadRepository.getThread("Politics").setComments("Just an other pointless comment to fill the void!");
//		Assertions.assertEquals(5, threadRepository.getThread("Politics").getNumOfComments());//check number of comments
//		Assertions.assertEquals("Just an other pointless comment to fill the void!", threadRepository.getThread("Politics").getSpecificComment(4)); //check newly wrote comment
//	}

}

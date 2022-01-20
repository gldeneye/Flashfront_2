package com.example.demo;

import org.springframework.stereotype.Service;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThreadRepository {
    private List<Thread> threads;

    public ThreadRepository() {
        threads = new ArrayList<>();
        threads.add(new Thread("Politics"));
        threads.add(new Thread("Conspiracy theories"));
        threads.add(new Thread("Economics"));
        threads.add(new Thread("IT-Solutions"));
        threads.add(new Thread("Cats"));
        threads.add(new Thread("Horses"));
        threads.add(new Thread("Crime"));
        threads.add(new Thread("Sad people"));
        threads.add(new Thread("Northern people"));
        threads.add(new Thread("Sad people"));
        threads.add(new Thread("Northern people"));

        getThread("Politics").setComments("I don't think your opinion is wrong, but it's not valid either");
        getThread("Politics").setComments("UGH I HATE PEOPLE WHOS OPINIONS DIFFER FROM MINE!!!!!");
        getThread("Politics").setComments("What is the funniest thing you ever saw on YouTube?");
        getThread("Politics").setComments("I am running for president, pls support me.");

        getThread("Conspiracy theories").setComments("The moon? Yeah, not real. My buddy Alan at work told me all about it. Apparently saw it in some movie or something, it's totally legit.");
        getThread("Conspiracy theories").setComments("Have you ever thought about how strange bellybuttons are? I think something is up with those..");
        getThread("Conspiracy theories").setComments("My UFO experience.");
        getThread("Conspiracy theories").setComments("Aliens will land on earth 22/12/22");
    }

    // get one thread
        public Thread getThread(String title) {
        for (Thread thread : threads) {
            if (thread.getTitle().equals(title)) {
                return thread;
            }
        }
        return null;
    }

    // get all threads
    public List<Thread> getThreads() {
        return threads;
    }

    // add a thread
    public Thread addThread(Thread thread) {
        Thread lastThread = threads.get(threads.size()-1);
        threads.add(thread);
        return thread;
    }

    public void editThread(Thread thread) {
    }


//     Ev adminfunktioner
//    // edit a book
//    public Book editBook(Book book) {
//        Book bookToEdit = this.getBook(book.getId());
//        if (bookToEdit != null) {
//            bookToEdit.setAuthor(book.getAuthor());
//            bookToEdit.setTitle(book.getTitle());
//            bookToEdit.setPrice(book.getPrice());
//        }
//        return book;
//    }
//    // delete a book
//    public void deleteBook(Long id) {
//        Book bookToDelete = this.getBook(id);
//        if (bookToDelete != null) {
//            books.remove(bookToDelete);
//        }
//    }
}

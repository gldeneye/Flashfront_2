package com.example.demo;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import org.springframework.stereotype.Service;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

@Service
public class ThreadRepository {
    private List<Thread> threads;

    public ThreadRepository() {
        threads = new ArrayList<>();
//        for (int i = 1; i <= 9; i++) {
//            books.add(new Book(new Long(200+i), "Book Title " + i, "Author name " + i, 40 + i));
//        }
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

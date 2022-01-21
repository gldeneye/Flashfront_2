package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThreadRepository {

    @Autowired
    private DataSource dataSource;


    private List<Thread> threads;

    public List<Thread> getAllThreads() {
        threads = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * from THREAD")) {

            while (rs.next()) {
                threads.add(rsThread(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return threads;
    }

    public Thread getThreadByName(String name) {
        Thread t = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM THREAD WHERE NAME = ?")) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                t = rsThread(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public Thread getThreadById(int id) {
        Thread t = null;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM THREAD WHERE ID =" + id)) {

            if (rs.next()) {
                t = rsThread(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    private Thread rsThread(ResultSet rs) throws SQLException {
        return new Thread(rs.getInt("id"),
                rs.getString("name"));
    }

    // get one thread

    public Thread getThread(String title) {
        for (Thread thread : threads) {
            if (thread.getName().equals(title)) {
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
        Thread lastThread = threads.get(threads.size() - 1);
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

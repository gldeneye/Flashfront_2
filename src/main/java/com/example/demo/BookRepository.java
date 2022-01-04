package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            books.add(new Book(new Long(200+i), "Book Title " + i, "Author name " + i, 40 + i));
        }
    }

    // get one book
    public Book getBook(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    // get all books
    public List<Book> getBooks() {
        return books;
    }

    // add a book
    public Book addBook(Book book) {
        Book lastBook = books.get(books.size()-1);
        book.setId(lastBook.getId()+1); // set an id on the new book, should be unique, will be done by the database in future exercises
        books.add(book);
        return book;
    }

    // edit a book
    public Book editBook(Book book) {
        Book bookToEdit = this.getBook(book.getId());
        if (bookToEdit != null) {
            bookToEdit.setAuthor(book.getAuthor());
            bookToEdit.setTitle(book.getTitle());
            bookToEdit.setPrice(book.getPrice());
        }
        return book;
    }

    // delete a book
    public void deleteBook(Long id) {
        Book bookToDelete = this.getBook(id);
        if (bookToDelete != null) {
            books.remove(bookToDelete);
        }
    }
}

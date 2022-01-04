package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String books(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Book> books = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("books", books);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);

        return "books";
    }

    @GetMapping("/book/{page}/{id}")
    public String book(Model model, @PathVariable Integer page, @PathVariable Long id) {
        Book book = bookRepository.getBook(id); // todo replace with call GET /book/{id}
        model.addAttribute("page", page);
        model.addAttribute("book", book);

        return "book";
    }


    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }

    private List<Book> getPage(int page, int pageSize) {
        List<Book> books = bookRepository.getBooks(); // todo replace with call GET /book
        int from = Math.max(0,page*pageSize);
        int to = Math.min(books.size(),(page+1)*pageSize);

        return books.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Book> books = bookRepository.getBooks(); // todo replace with call GET /book
        return (int)Math.ceil(new Double(books.size()) / pageSize);
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Book book) {
        if (book.isNew()) {
            bookRepository.addBook(book); // todo replace with call POST /book (with book object as json in request body)
        }
        else {
            bookRepository.editBook(book);
            // todo replace with call PUT /book/{id} (with book object as json in request body
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Book book = bookRepository.getBook(id); // todo replace with call GET /book/{id}
        model.addAttribute(book);
        return "form";
    }

}

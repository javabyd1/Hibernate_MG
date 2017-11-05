package com.no_company.hibernate;

import com.no_company.hibernate.model.BookEntity;
import com.no_company.hibernate.model.BookDAO;
import org.hibernate.Session;

import java.math.BigDecimal;

import static com.no_company.hibernate.util.HibernateSessions.getConfiguredSession;

public class ConsoleTest {

    public static void main(String[] args) {

        Session session = getConfiguredSession();

        BookEntity book = new BookEntity();
        book.setTitle("Necronomicon");
        book.setAuthor("Abdul Alhazred");
        book.setOnStock(1);
        book.setPrice( new BigDecimal(19.99));

        BookDAO dao = new BookDAO();
        dao.addBook(book);

    }

}

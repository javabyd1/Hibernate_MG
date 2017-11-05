package com.no_company.hibernate.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import static com.no_company.hibernate.util.HibernateSessions.closeSessionFactory;
import static com.no_company.hibernate.util.HibernateSessions.getConfiguredSession;

public class BookDAO {

    public Integer addBook(BookEntity book) {
        Transaction tx = null;
        Integer bookID = null;
        try ( Session session = getConfiguredSession() ) {
            tx = session.beginTransaction();
            bookID = (Integer) session.save(book);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) tx.rollback();
            he.printStackTrace();
        } finally {
            closeSessionFactory();
        }
        return bookID;
    }

    public Integer addBooks(List<BookEntity> books) {
        Integer lastID = null;
        for (BookEntity book : books) {
            lastID = addBook(book);
        }
        return lastID;
    }

    public BookEntity getBook(int bookID) {
        Transaction tx = null;
        BookEntity book = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            book = session.get(BookEntity.class, bookID);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            he.printStackTrace();
        } finally {
            closeSessionFactory();
        }
        return book;
    }

    public List<BookEntity> getAllBooks() {
        Transaction tx = null;
        List<BookEntity> allBooks = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            allBooks = session.createQuery("FROM BookEntity").list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            he.printStackTrace();
        } finally {
            closeSessionFactory();
        }
        return allBooks;
    }

    public BookEntity getBookByTitle(String title) {
        List<BookEntity> allBooks = getAllBooks();
        for (BookEntity book : allBooks) {
            if (book.getTitle().contains(title)) return book;
        }
        return null;
    }

    public List<BookEntity> getBooksByAuthor(String author) {
        List<BookEntity> authorBooks = new ArrayList<>();
        List<BookEntity> allBooks = getAllBooks();
        for (BookEntity book : allBooks) {
            if (book.getAuthor().contains(author)) allBooks.add(book);
        }
        return authorBooks;
    }

    public List<BookEntity> getBooksByPublisher(String publisher) {
        List<BookEntity> publisherBooks = new ArrayList<>();
        List<BookEntity> allBooks = getAllBooks();
        for (BookEntity book : allBooks) {
            if (book.getPublisher().contains(publisher)) allBooks.add(book);
        }
        return publisherBooks;
    }

}

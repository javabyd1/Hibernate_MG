package com.no_company.hibernate;

import com.no_company.hibernate.model.BooksEntity;
import org.hibernate.Session;

import static com.no_company.hibernate.util.HibernateSessions.getConfiguredSession;

public class ConsoleTest {

    public static void main(String[] args) {

        Session session = getConfiguredSession();
        BooksEntity be = new BooksEntity();
    }

}

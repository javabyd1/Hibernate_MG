package com.no_company.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books", schema = "bookstore")
public class BookEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false) private int id;
    @Column private String title;
    @Column private String author;
    @Column private String category;
    @Column private String publisher;
    @Column private Date published;
    @Column private String isbn;
    @Column private Integer pageCount;
    @Column private Integer onStock;
    @Column private BigDecimal price;

}

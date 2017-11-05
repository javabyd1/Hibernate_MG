package com.no_company.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books", schema = "bookstore")
public class BooksEntity {

    @Id @Column (nullable = false) private int id;
    @Column private String title;
    @Column private String author;
    @Column private Date published;
    @Column private String isbn;
    @Column private String category;
    @Column private Integer pageCount;
    @Column private String publisher;
    @Column private BigDecimal price;
    @Column private Integer onStock;

}

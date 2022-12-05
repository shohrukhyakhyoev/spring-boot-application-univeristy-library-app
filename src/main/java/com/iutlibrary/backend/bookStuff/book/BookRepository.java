package com.iutlibrary.backend.bookStuff.book;

import com.iutlibrary.backend.bookStuff.bookItem.BookItem;
import com.iutlibrary.backend.utility.enums.BookStatus;
import com.iutlibrary.backend.utility.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.ISBN = ?1")
    Optional<Book> findByISBN(Long isbn);

    @Query("SELECT b FROM Book b WHERE lower(b.title) LIKE lower(concat('%', :title, '%')) ")
    List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b WHERE lower(b.author) LIKE lower(concat('%', :author, '%')) ")
    List<Book> findByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE lower(b.subject) LIKE lower(concat('%', :subject, '%')) ")
    List<Book> findBySubject(String subject);

}

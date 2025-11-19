package eus.birt.ad.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.ad.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

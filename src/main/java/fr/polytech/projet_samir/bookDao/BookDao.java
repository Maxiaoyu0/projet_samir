package fr.polytech.projet_samir.bookDao;

import fr.polytech.projet_samir.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book,Integer> {
}

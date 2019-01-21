package fr.polytech.projet_samir;

import fr.polytech.projet_samir.book.Book;
import fr.polytech.projet_samir.bookDao.BookDao;
import fr.polytech.projet_samir.user.User;
import fr.polytech.projet_samir.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetSamirApplication {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(ProjetSamirApplication.class, args);
    }


}


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
@RestController
public class ProjetSamirApplication {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void addData2DB(){
        userDao.saveAll(Stream.of(new User(744,"ma"),new User(455,"xiaoyu")).collect(Collectors.toList()));
        bookDao.saveAll(Stream.of(new Book(111,"core java"),new Book(222,"spring boot")).collect(Collectors.toList()));
    }
    @GetMapping("/getUsers")
    public List<User> getUsers()
    {
        return userDao.findAll();
    }
    @GetMapping("getBooks")
    public List<Book>   getBooks(){
        return bookDao.findAll();
    }

    @GetMapping("/")
    public void syso(){
        System.out.println("hello jenkins");
    }
    public static void main(String[] args) {
        SpringApplication.run(ProjetSamirApplication.class, args);
    }


}


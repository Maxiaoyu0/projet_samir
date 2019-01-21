package fr.polytech.projet_samir.controller;

import fr.polytech.projet_samir.book.Book;
import fr.polytech.projet_samir.bookDao.BookDao;
import fr.polytech.projet_samir.user.User;
import fr.polytech.projet_samir.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program:
 * @description:
 * @author: M. Maxiaoyu
 * @create: 2019-01-21 14:12
 **/
@RestController
@RequestMapping("/info")

public class Usercontroller {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;
    @PostConstruct
    public void addData2DB(){
        userDao.saveAll(Stream.of(new User(744,"ma"),new User(455,"xiaoyu")).collect(Collectors.toList()));
        bookDao.saveAll(Stream.of(new Book(111,"core java"),new Book(222,"spring boot")).collect(Collectors.toList()));
    }
    @GetMapping("/allusers")
    public List<User> getUsers()
    {
        return userDao.findAll();
    }
    @GetMapping("/allbooks")
    public List<Book>   getBooks(){
        return bookDao.findAll();
    }

    @PostMapping("/adduser")
    public User adduser(@RequestBody User user){
        return userDao.save(user);
    }
    @PostMapping("/addbook")
    public Book addbook(@RequestBody Book book){
        return bookDao.save(book);
    }
    @DeleteMapping("/deleteuser/{id}")
    public void deleteuser(@PathVariable int id ){
        userDao.deleteById(id);
    }
    @DeleteMapping("/deletebook/{id}")
    public void deletebook(@PathVariable int id ){
        bookDao.deleteById(id);
    }
}

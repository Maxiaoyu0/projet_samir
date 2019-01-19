package fr.polytech.projet_samir.userDao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.polytech.projet_samir.user.*;
@Repository
public interface UserDao extends JpaRepository<User,Integer> {


}

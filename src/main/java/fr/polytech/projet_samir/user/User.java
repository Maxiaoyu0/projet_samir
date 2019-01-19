package fr.polytech.projet_samir.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program:
 * @description:
 * @author: M. Maxiaoyu
 * @create: 2019-01-19 16:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="userdb")
public class User {
    @Id
    private int id;

    private String username;
}
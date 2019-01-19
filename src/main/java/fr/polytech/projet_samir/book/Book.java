package fr.polytech.projet_samir.book;

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
 * @create: 2019-01-19 16:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookdb")
public class Book {
    @Id
    private int id;

    private String name;
}

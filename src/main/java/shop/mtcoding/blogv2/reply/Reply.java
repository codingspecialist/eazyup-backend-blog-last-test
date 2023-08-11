package shop.mtcoding.blogv2.reply;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.blogv2.board.Board;
import shop.mtcoding.blogv2.user.User;

@Setter
@Getter
@Table(name = "reply_tb")
@Entity
public class Reply {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false, length = 100)
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Board board;

    private Timestamp createdAt;
}

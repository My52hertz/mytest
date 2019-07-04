package com.bjsxt.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sunyi,
 * @date 2019/6/4,
 * @time 00:15,
 *
 *
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="u_id")
    private Integer u_id;
    @Column(name="username")
    private String username;
    @Column(name="userage")
    private Integer userage;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }
}

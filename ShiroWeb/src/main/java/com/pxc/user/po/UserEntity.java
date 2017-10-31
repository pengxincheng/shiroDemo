package com.pxc.user.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by pxc on 2017/10/30.
 */
@Entity
@Table(name = "tab_user")
public class UserEntity {
    private String id;
    private String username;
    private String password;
    private String roleId;
    private String remark;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "userGenerator")
    @GenericGenerator(name = "userGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
    @Column(name="user_name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

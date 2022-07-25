package com.example.hellojsf;

import com.example.hellojsf.model.User;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean {
    private User user;
    private User selectedUser;

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    private List <User> userList;
/*
    public UserBean(){
       user=new User();
       userList = new ArrayList<>();
        selectedUser = new User();
    }*/

    @PostConstruct
    public void init(){
        selectedUser = new User();
        user = new User();
        userList = new ArrayList<>();
    }

    public void addUser(){
        userList.add(user);
        user=new User();

    }

    public void clearUser(){
        user = new User();
    }
    public void editUser(){
        User editUser = userList.stream()
                .filter(user1 -> user1.getId()==user.getId())
                .findFirst().get();
       userList.remove(editUser);
       userList.add(user);
       user = new User();
    }

    public void selectForEdit(User editUser){
        user=editUser;
    }

    public void deleteUser(User deleteUser){
        userList.remove(deleteUser);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


}

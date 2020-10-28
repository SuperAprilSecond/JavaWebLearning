package dao;

import entity.User;

import java.util.List;

public interface IUserdao {
    public boolean login(String name,String pwd);//login
    public boolean register(User user);//register user
    public List<User> getUserAll();//return userList
    public boolean delete(int id);
    public boolean updateUser(int id, String name, String pwd, String sex, String home, String info);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstocktrader.service;


import com.smartstocktrader.pojo.Display;
import com.smartstocktrader.pojo.Review;
import com.smartstocktrader.pojo.User;
import java.util.*;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service("userService")
@Transactional
public class UserService {
    SessionFactory sf;

    @Resource(name="sessionFactory")
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
    
    @Transactional(readOnly = true)
    public List<User> getAllUser(){
        List<User> list=sf.getCurrentSession().createCriteria(User.class).list();
        return list;
    }
    
    @Transactional(readOnly = true)
    public  User getUser( String email, String pass){
        User user=new User();
        List<User> users=sf.getCurrentSession().createQuery("from User where email='"+email+"' and remark='"+pass+"'").list();
        for(User u:users){
            user=u;
        }
                
        
//        Query q=sf.getCurrentSession().createSQLQuery("select * from user where email=? and remark=?");
//        q.setParameter(0, email);
//        q.setParameter(1, pass);
//        List<User> users=q.list();
//        User user=users.get(0);
         
        
        return user  ;
    }
    
    public String register(User user){
        try{
            sf.getCurrentSession().saveOrUpdate(user);
        }catch(Exception e){
            return "fail";
        }
        return "success";
    }
    
    public List<Display> getAllDisplayItems(){
        List<Display> list=new ArrayList<Display>();
        list=sf.getCurrentSession().createCriteria(Display.class).list();
        return list;
    }
    
    public User androidTest(){
        List<User> users=sf.getCurrentSession().createQuery("from User where user_id=1").list();
        User user=new User();
        for(User u:users){
            user=u;
        }
        return user;
    }
    
    public List<Review> getById(int id){
        List<Review> list=sf.getCurrentSession().createQuery("from Review where stockId="+id).list();
        return list;
    }
    
    public void saveReview(Review review){
        
    }
    

    
   
    
}

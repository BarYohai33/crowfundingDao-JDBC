package com.dao;

import java.sql.*; 
import java.util.ArrayList;
import java.util.List;

import com.bean.User;

public class UserDaoImpl implements UserDao {
    private DaoFactory daoFactory;

    UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(User user) /*throws DaoException */{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO User (email, password, firstname, lastname) VALUES(?, ?, ?, ?);");
            
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());

            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
          /* throw new DaoException("email deja utiliser");*/
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> lister() {
        List<User> users = new ArrayList<User>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT email FROM User;");

            while (resultat.next()) {
            	
                String email = resultat.getString("email");
                

                User user = new User();
                user.setEmail(email);
               

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    

}
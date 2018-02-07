package com.dao;

import java.sql.Connection;   
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.Edit;



public class EditDaoImpl implements EditDao{
	private DaoFactory daoFactory;

    EditDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    

    public void ajouter(Edit edit) /*throws DaoException */{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO Edit (titre, projet) VALUES(?, ?);");
            preparedStatement.setString(1, edit.getTitre());
            preparedStatement.setString(2, edit.getProjet());
            
            //preparedStatement.setString(3, ${ sessionScope.email });
  

            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
          /* throw new DaoException("email deja utiliser");*/
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

	@Override
	public List<Edit> lister() {
		// TODO Auto-generated method stub
		List<Edit> edits = new ArrayList<Edit>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT titre,projet FROM Edit;");
			
			while (resultat.next()) {
				String titre = resultat.getString("titre");
				String projet = resultat.getString("projet");
				
				Edit edit = new Edit();
				edit.setTitre(titre);
				edit.setProjet(projet);
				
				edits.add(edit);
				
				
			}
			
		}  catch (SQLException e) {
	            e.printStackTrace();
	        }
		return edits;
	}


}

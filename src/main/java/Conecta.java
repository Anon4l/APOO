package main.java;

import java.sql.*;
import javax.swing.*;

public class Conecta {
    public Connection connection = null;

    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/bd";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "xpostgresx321";
    private PreparedStatement statement;
    private String  sql;
    private ResultSet resultSet;
    public boolean getConnection(){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return true;
        }catch (ClassNotFoundException erro){
           JOptionPane.showMessageDialog(null, "Driver nao encontrado: " + erro.toString());
           return false;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao conectar: " + erro.toString());
           return false; 
        }
    }

    public boolean localizar(String login, String senha){
        sql = "SELECT * FROM conta WHERE login = ? and senha = ?";
        try{
            getConnection();
            statement = this.connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, senha);
            resultSet = statement.executeQuery();
            resultSet.next();
            if(resultSet.getString("login").equals(login)
             && resultSet.getString("senha").equals(senha)){
                return true;
            }else{
                return false;
            }
            
        }catch (Exception e){
            this.close();
            return false;
            
        }
  
    }

    public boolean cadastrar(String login, String senha)
    {
        try {
        getConnection();
        sql = "INSERT INTO conta (login,senha) VALUES (?,?)";
        statement = this.connection.prepareStatement(sql);
        statement.setString(1,login);
        statement.setString(2,senha);
        statement.executeUpdate();
        this.close();
        return true;

    }catch (Exception e){
        this.close();
        return false;
    }

    }
    
    
    public void close(){
        try{
            connection.close();
             
        }catch (SQLException erro){

        }
    }
}

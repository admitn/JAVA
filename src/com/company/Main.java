package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main {
    public static void main(String[] args){

        JFrame frame = new JFrame("AppSqlite");
        frame.setSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        TableModal tm = new TableModal();
        JTable table = new JTable(tm);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(400,400));

        frame.add(tableScroll, new GridBagConstraints(0,0,1,1,0,0,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1,1,1,1),0,0));

        try{
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:sqlite.db");

            Statement st = co.createStatement();
            String query ="SELECT * FROM Contact";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String []row = {
                        rs.getString("id"),
                        rs.getString("Name"),
                        rs.getString("Family"),
                        rs.getString("Age")
                };
                tm.AddDate(row);
            }
            co.close();
            st.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        frame.setVisible(true);
        frame.pack();
    }
}

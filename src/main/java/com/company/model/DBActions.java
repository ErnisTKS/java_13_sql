package com.company.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBActions {

    public static void printResultSet(ResultSet values) {
        try {
            ResultSetMetaData lentelesInformacija = values.getMetaData();
            int[] raidziuKiekis = new int[lentelesInformacija.getColumnCount()];
            for (int i = 1; i <= lentelesInformacija.getColumnCount(); i++) {
                System.out.println(lentelesInformacija.getCatalogName(i) + "\t");
                raidziuKiekis[i - 1] = lentelesInformacija.getColumnName(i).length();
            }
            while (values.next()) {
                System.out.println("");
                for (int i = 1; i <= lentelesInformacija.getColumnCount(); i++){
                    String value = values.getString(i);
                    if (value != null){
                        while (value.length() < raidziuKiekis[i-1]){
                            value += " ";
                        }
                        System.out.println(value + "\t");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

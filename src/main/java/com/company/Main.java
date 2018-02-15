package com.company;

import com.company.model.DBActions;

import java.sql.*;
import java.util.Scanner;

public class Main {

    DBActions obj2 = new DBActions();
    public static final int ACTION_0 = 0;
    public static final int ACTION_1 = 6;
    public static final int ACTION_2 = 7;
    public static final int ACTION_3 = 8;
    public static final int ACTION_4 = 9;
    public static final int ACTION_5 = 10;
    public static final int ACTION_6 = 12;
    public static final int ACTION_7 = 14;
    public static final int ACTION_8 = 15;
    public static final int ACTION_9 = 16;
    public static final int ACTION_10 = 17;
    public static final int ACTION_11 = 18;
    public static final int ACTION_12 = 19;

    public static void main(String[] args) {
        Main obj = new Main();
        obj.run();
    }

    private void rodykMeniu() {
        System.out.println("+==============================+");
        System.out.println(ACTION_1+" uzduotis");
        System.out.println(ACTION_2+" uzduotis");
        System.out.println(ACTION_3+" uzduotis");
        System.out.println(ACTION_4+" uzduotis");
        System.out.println(ACTION_5+" uzduotis");
        System.out.println(ACTION_6+" uzduotis");
        System.out.println(ACTION_7+" uzduotis");
        System.out.println(ACTION_8+" uzduotis");
        System.out.println(ACTION_9+" uzduotis");
        System.out.println(ACTION_10+" uzduotis");
        System.out.println(ACTION_11+" uzduotis");
        System.out.println(ACTION_12+" uzduotis");
        System.out.println("+==============================+");
    }


    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        while (arTesti) {
            rodykMeniu();
            int veiksmas = sc.nextInt();
            switch (veiksmas) {
                case ACTION_0:
                    arTesti = false;
                    break;
                case ACTION_1:
                    Studentai("SELECT * FROM `students` ORDER BY `students`.`name` ASC");
                    break;
                case ACTION_2:
                    Studentai("SELECT * FROM `students` WHERE `name` LIKE '%as' ORDER BY `surname` DESC");
                    break;
//                case ACTION_3:
//                    StudentuAdresai("SELECT * FROM `student_address` WHERE `city` LIKE 'Kaunas'");
//                    break;
//                case ACTION_4:
//                    StudentuAdresai("SELECT * FROM `student_address` WHERE `post_code` IS NOT NULL");
//                    break;
//                case ACTION_5:
//                    StudentuMark("SELECT * FROM `student_marks` ORDER BY `student_marks`.`mark` DESC");
//                    break;
//                case ACTION_6:
//                    StudentuMark("SELECT * FROM `student_marks` WHERE `mark` > 6");
//                    break;
//                case ACTION_7:
//                    StudentuLeftJOIN("SELECT `students`.`name`, `student_address`.`street` FROM `students` LEFT JOIN `student_address` ON `students`.`id`=`student_address`.`student_id` ORDER BY `students`.`name` ASC");
//                    break;
//                case ACTION_8:
//                    StudentuRightJOIN("SELECT `students`.`name`, `student_marks`.`mark` FROM `students` RIGHT JOIN `student_marks` ON `students`.`id`=`student_marks`.`student_id` ORDER BY `student_marks`.`mark` DESC");
//                    break;
//                case ACTION_9:
//                    StudentuInnerJOIN("SELECT `students`.`name`, `student_address`.`city`, `student_marks`.`mark`" +
//                "FROM `students` " +
//                "       INNER JOIN `student_marks` " +
//                "       ON `students`.`id`=`student_marks`.`student_id`" +
//                "       INNER JOIN `student_address` " +
//                "       ON `students`.`id`=`student_address`.`student_id`" +
//                "            WHERE `name` LIKE '%as' AND `student_address`.`city` LIKE 'Kaunas'");
//                    break;
//                case ACTION_10:
//                    StudentuInnerJOIN2("SELECT `students`.`name`, `student_address`.`city`, `student_marks`.`mark`\n" +
//                            "FROM `students` " +
//                            "       INNER JOIN `student_marks` " +
//                            "       ON `students`.`id`=`student_marks`.`student_id`" +
//                            "       INNER JOIN `student_address` " +
//                            "       ON `students`.`id`=`student_address`.`student_id`" +
//                            "          " +
//                            "            WHERE `student_marks`.`mark` IS NULL AND `student_address`.`city` IS NULL");
//                    break;
//                case ACTION_11:
//                    StudentuMark("SELECT * FROM `student_marks` ORDER BY `student_marks`.`mark` DESC LIMIT 10");
//                    break;
//                case ACTION_12:
//                    Studentu19("");
//                    break;
            }
        }

    }

    public void Studentai(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kcs",
                    "root",
                    ""
            );
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(sql);

            System.out.println();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

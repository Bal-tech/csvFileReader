package com.zorba;

import com.zorba.pojo.Employee;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        // using Relative Path to load the file
        URL url = App.class.getClassLoader().getResource("myCSVfile.csv");
        File file = new File(url.getPath());
        // print the path of the CSV File
        System.out.println("CSV File Relative Path: " + file);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        //System.out.println(bufferedReader);
        String line = ""; // variable that holds string

        // ctrl + shift + / --> for commenting out block of codes
        /*while((line = bufferedReader.readLine())!= null){
            System.out.println(line);

        }*/

        //skip the file header
        if (bufferedReader != null) {
            bufferedReader.readLine();
        }

        List<String> employeeList = new ArrayList<>(); // create a list of Employees
        while ((line = bufferedReader.readLine()) != null) {
            String[] csvFile = line.split(",");
            Employee employees = new Employee(); // Employee object
            // populate all contents of file read in a list
                employees.setName(csvFile[0]);
                employees.setDateOfBirth(csvFile[1]);
                employees.setGender(csvFile[2]);
                employees.setAddress(csvFile[3]);
                try{
                    employees.setSalary(Double.parseDouble(csvFile[4])); // convert string to double
                }
                catch (NumberFormatException e){
                    employees.setSalary(0);// set to zero
                }
                employeeList.add(String.valueOf(employees)); // add each employee to the List
        }
        System.out.println("Employee Object Contents: " + employeeList);
            /*for (String s : csvFile) {
                employeeList..add(s); // populate all contents of file read in a list
            }*/

            //print contents of a file
            /*System.out.println("Name: " + csvFile[0]);
            System.out.println("Date of Birth: " + csvFile[1]);
            System.out.println("Gender: " + csvFile[2]);
            System.out.println("Address: " + csvFile[3]);
            System.out.println("Salary: " + csvFile[4]);*/


        /*line = " Randy, 07-09-1980, M, 65, Hayward"; // a string variable
        String [] texts = line.split(",");
        for(String s:texts) {
            System.out.println(s); // split a whole string into several lines
        }*/

    }
}

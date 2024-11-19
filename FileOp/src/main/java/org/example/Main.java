package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "Students.csv";
        String outputFile = "Students_with_grades.csv";

        List<Student> students = readStudentsProfile(inputFile);

        for(Student student : students){
            student.addGrade("Math", Math.round(Math.random()*100));
            student.addGrade("Literature", Math.round(Math.random()*100));
            student.addGrade("Chemistry", Math.round(Math.random()*100));
            student.addGrade("Computer Science", Math.round(Math.random()*100));
        }

        System.out.println(students);
    }
    private static List<Student> readStudentsProfile(String filename){
        List<Student> students = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) !=null){
                students.add(new Student(line.trim()));
            }

        } catch(IOException e){
            System.out.println("Error reading file " + e.getMessage());
        }

        return students;
    }

    private static void writeStudentsProfile(List<Student> students, String filename){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            bw.write("Name, Subject, Grade, Average");

        }catch(IOException e){

        }
    }
}
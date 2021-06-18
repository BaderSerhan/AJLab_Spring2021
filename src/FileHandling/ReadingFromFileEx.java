package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFromFileEx {

    public static void main(String[] args) throws FileNotFoundException {
        File grades = new File("grades.txt");
        Scanner scan = new Scanner(grades);
        String fName = null;
        String lName = null;
        String fMaxName = null;
        String lMaxName = null;
        double maxGrade = 0, sum = 0, average, grade = 0, maxStGrade = 0;
        int records = 0;
        while (scan.hasNext()) {
            fName = scan.next();
            lName = scan.next();
            grade = scan.nextDouble();
            sum += grade;
            records++;
            if (grade > maxGrade) {
                maxGrade = grade;
                fMaxName = fName;
                lMaxName = lName;
                maxStGrade = grade;
            }
        }
        System.out.println("The first in the class is: " + fMaxName + " " + lMaxName + " " + maxStGrade);
        average = sum / records;
        System.out.println("Average= " + average);
        System.out.println("Max grade= " + maxGrade);
    }
}

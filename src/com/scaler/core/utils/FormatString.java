package com.scaler.core.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @created 02/04/23 8:43 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class FormatString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String fileName = str.replaceAll(" ", "_").replaceAll("\\.", "")
                .replaceAll("-", "_").replaceAll("'", "")
                .replaceAll(",", "")
                .replaceAll("&", "and")
                .replaceAll("%", "_mod_");
        System.out.println();
        System.out.println(fileName);
        String path = "/Users/deepakkumar/Desktop/deepak/study_related/intellij_workspace/scaler_course_code/src/com/scaler/core/java_satya/java_3_advance_1/";
        String packageName = "dsa_01_arrays_1";
        String assignment = "assignment";
        String homeWork = "homework";
        boolean isHomeWork = true;
        if (!isHomeWork) {
            path = path + packageName + "/" + assignment + "/";
        } else {
            path = path + packageName + "/" + homeWork + "/";
        }
        System.out.println();
        writeReadMeFile(fileName, path);
        in.close();
    }

    private static void writeReadMeFile(String fileName , String path) {
        Path readMeFilePath = Paths.get("/Users/deepakkumar/Desktop/deepak/study_related/intellij_workspace/scaler_course_code/src/com/scaler/core/readme-template.md");
        File createReadmeFile = new File( path + fileName + ".md");
        try {
            boolean value = createReadmeFile.createNewFile();

            if (value) {
                byte[] arr = Files.readAllBytes(readMeFilePath);
                Files.write(createReadmeFile.toPath(), arr);
                System.out.println("New " + fileName + " File is created.");
            } else {
                System.out.println("The file already exists.");
                System.out.println("The " + fileName + " file already exists.");
            }
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}

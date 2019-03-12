package com.fileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileReader {
    ArrayList<String> lines;
    public FileReader(String filePath) {
        try {
            FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + filePath);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String strLine;
            lines = new ArrayList<String>();
            while ((strLine = bufferedReader.readLine()) != null)   {
                lines.add(strLine);
            }
            if (lines.size() > 2 ) {
                throw new Exception("Wrong file format. There should be max two lines.");
            }
            if (lines.size() < 2) {
                throw new Exception("Looks like you missing arguments for operation.");
            }
        }
        catch (FileNotFoundException fnfEx) {
            System.out.println("File with path " + filePath +" was not founded.");
            System.err.println("Error: " + fnfEx.getMessage());
        }
        catch (IOException ioEx) {
            System.err.println("Error: " + ioEx.getMessage());
        }
        catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    public String getOperation() {
        String result = null;
        try {
            if (lines.size() == 0) {
                throw new Exception("Read file first!");
            }
            return lines.get(0);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return null;
    }
    public ArrayList<Integer> getListOfArguments() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String listByString = lines.get(1);
        String [] listOfStrings = listByString.split(Pattern.quote(" "));
        for (String el: listOfStrings) {
            result.add(Integer.parseInt(el));
        }
        return result;
    }
}

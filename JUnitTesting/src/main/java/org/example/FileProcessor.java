package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException{
        try(FileWriter fw = new FileWriter(filename)){
            fw.write(content);
            System.out.println("Contents are written into "+filename);
        }
    }

    public String readFromFile(String filename) throws IOException{
        StringBuilder sb = new StringBuilder();
        try(FileReader fr = new FileReader(filename)){
            int i;
            while ((i = fr.read()) != -1){
                sb.append((char) i);
            }
            System.out.println("Contents are read from "+filename);
        }
        return sb.toString();
    }
}

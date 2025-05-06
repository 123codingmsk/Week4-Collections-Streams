package org.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    FileProcessor fp = new FileProcessor();
    String filename = "names.txt";
    String content = "manoj sai kumar";
    @Test
    void testwriteToFile() throws IOException{
        fp.writeToFile(filename, content);
        String result = fp.readFromFile(filename);
        assertEquals(content, result);
    }

    @Test
    void testNonExistfile(){
        String invalidfile = "jonam.txt";
        assertThrows(IOException.class, ()->{fp.readFromFile(invalidfile);});
    }
}
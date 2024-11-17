package com.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class Methods {
    /**
     * @param message
     * @throws IOException
     */
    BufferedWriter writer;
    public void write(String message)  {
        try{
            File Debug = new File("src/main/java/com/app/Debug/Debug.txt");
            if(!Debug.exists()) {
                Debug.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(Debug));
            writer.write(message);
            writer.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            try{
                write("Error in closing the writer /n");
                write(e.getMessage());
                writer.flush();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
}

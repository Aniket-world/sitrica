package com.app;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import com.app.App;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        
    }

    @Test
    public void toDebug(){
        Methods methods = new Methods();
        long nano = System.nanoTime();
        try{
            methods.write("Test message :" + nano);
        }catch(Exception e){
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/app/Debug/Debug.txt"))) {
            String line ; 
            boolean found = false;
            while((line = reader.readLine()) != null){
                if(line.contains("Test message :" + nano)){
                    found = true;
                    break;
                }
            }
            reader.close();
            methods.close();
            assertTrue(found);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

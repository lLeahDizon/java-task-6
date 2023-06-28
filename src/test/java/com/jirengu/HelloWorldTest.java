package com.jirengu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    PrintStream originalOut;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setup() {
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintHelloWorld() {
        // Act
        HelloWorld.main(null);

        // Assert: 验证输出是否为 "Hello World"
        String output = outputStream.toString().trim();
        assertEquals("Hello World", output);
    }
}

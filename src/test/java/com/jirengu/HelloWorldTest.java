package com.jirengu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    @Test
    public void testPrintHelloWorld() {
        // 保存标准输出流的引用
        PrintStream originalOut = System.out;

        try {
            // Arranage
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);

            System.setOut(printStream);

            // Act
            HelloWorld.main(null);

            // Assert: 验证输出是否为 "Hello World"
            String output = outputStream.toString().trim();

            assertEquals("Hello World", output);
        } finally {
            // 恢复标准输出流
            System.setOut(originalOut);
        }
    }
}

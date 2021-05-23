package com.qyc.jupiter.lamada;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();

        // TODO 此处替换为本地文件的地址全路径
        String filePath = "/Users/qiyuanchun/logs/csp/command-center.log.2020-08-17.0";

        // 通过lambda表达式，打印文件内容
        fileService.fileHandle(filePath,

                System.out::println);


        fileService.fileHandle(filePath,  System.out::println);
    }

    @Test
    public void fileHandleConsumerTest() throws IOException {
        FileService fileService = new FileService();

        // TODO 此处替换为本地文件的地址全路径
        String filePath = "/Users/qiyuanchun/logs/csp/command-center.log.2020-08-17.0";

        // 通过lambda表达式，打印文件内容
        fileService.fileHandle(filePath,

                System.out::println);


        fileService.fileHandleConsumer(filePath,  System.out::println);
    }




    @Test
    public void fileHandleFunctionTest() throws IOException {
        FileService fileService = new FileService();

        // TODO 此处替换为本地文件的地址全路径
        String filePath = "/Users/qiyuanchun/logs/csp/command-center.log.2020-08-17.0";

        // 通过lambda表达式，打印文件内容

        fileService.FileFunctionTest(filePath,(String str) -> str.chars().count());


    }


    @Test
    public void fileHandleSupplierTest() throws IOException {
        FileService fileService = new FileService();

        // TODO 此处替换为本地文件的地址全路径
        String filePath = "/Users/qiyuanchun/logs/csp/command-center.log.2020-08-17.0";

        // 通过lambda表达式，打印文件内容


        fileService.FileSupplierTest(filePath,() ->{
            return "返回结果";
        });
    }
}

package com.study.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;

@Slf4j
public class IOUtilsTest {
    private String writePath="text.txt";

    private String readPath="";

    @Test
    public void testRead(){
        File file=new File(writePath);
        try (BufferedReader reader=IOUtils.buffer(new FileReader(file))){
         String test=reader.readLine();
         log.info("读取的内容为:{}",test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试ioutils工具写入
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testWrite() throws FileNotFoundException, UnsupportedEncodingException {
        String s="addsdvdvvd";
        File file=new File(writePath);
        try (BufferedOutputStream bufferedOutputStream=IOUtils.buffer(new FileOutputStream(file));){
            byte[] bytes=s.getBytes("utf-8");
            bufferedOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}

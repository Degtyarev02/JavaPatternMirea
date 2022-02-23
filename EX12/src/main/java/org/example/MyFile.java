package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.crypto.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Component()
public class MyFile {
    File fileInit;
    File fileWithEncode;

    public MyFile() {
        fileInit = new File("C://Users//User//Desktop//JavaPatternMirea//EX12//src//main//java//org//example//file1.txt");
        fileWithEncode = new File("C://Users//User//Desktop//JavaPatternMirea//EX12//src//main//java//org//example//file2.txt");
    }

    //Метод вызывается после создания бина
    @PostConstruct
    public void init() {
        try {
            System.out.println("INIT");

            //Записыываем в 1 файл строку
            FileWriter writer = new FileWriter(fileInit.getAbsolutePath(), false);
            writer.write("Hello world");
            writer.close();

            FileWriter writer2 = new FileWriter(fileWithEncode.getAbsolutePath(), false);
            FileReader reader = new FileReader(fileInit.getAbsolutePath());
            int symbol;
            String s = "";
            while ((symbol = reader.read()) != -1) {
                s += ((char) symbol);
            }

            System.out.println(s);

            //Исползьуем алгоритм шифрования AES
            Cipher cipher = Cipher.getInstance("AES");

            //Генерируем случайный секретный ключ размером 128 бит
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            SecretKey key = kgen.generateKey();

            //Инициализируем метод шифрования передавая константу на шифрование и секретный ключ
            cipher.init(Cipher.ENCRYPT_MODE, key);

            //Шифруем текст и записываем в файл
            byte[] bytes = cipher.doFinal(s.getBytes(StandardCharsets.UTF_8));

            for (byte aByte : bytes) {
                writer2.write(String.valueOf(aByte));
            }
            reader.close();
            writer2.close();
        } catch (IOException | NoSuchAlgorithmException
                | NoSuchPaddingException | InvalidKeyException
                | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        if (fileInit.delete()) {
            System.out.println("DESTROY IS COMPLETE");
        } else {
            System.out.println("File is not deleted");
        }
    }
}

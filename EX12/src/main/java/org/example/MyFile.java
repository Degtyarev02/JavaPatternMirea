package org.example;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Value;
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

@Component
public class MyFile {
    File fileInit;
    File fileWithEncode;

    @Value("#{springApplicationArguments.sourceArgs[0]}")
    private String inputFilePath;

    @Value("#{springApplicationArguments.sourceArgs[1]}")
    private String hashFilePath;

    //Метод вызывается после создания бина
    @PostConstruct
    public void init() {

        try {
            System.out.println("INIT");

            fileInit = new File("C://Users//User//Desktop//JavaPatternMirea//EX12//src//main//java//org//example//" + inputFilePath + ".txt");
            fileWithEncode = new File("C://Users//User//Desktop//JavaPatternMirea//EX12//src//main//java//org//example//" + hashFilePath + ".txt");

            //Записыываем в 1 файл строку
            FileWriter writer = new FileWriter(fileInit.getAbsolutePath(), false);
            writer.write("Hello world");
            writer.close();

            FileWriter writer2 = new FileWriter(fileWithEncode.getAbsolutePath(), false);
            FileReader reader = new FileReader(fileInit.getAbsolutePath());

            int symbol;
            StringBuilder s = new StringBuilder();
            while ((symbol = reader.read()) != -1) {
                s.append((char) symbol);
            }

            //Генерируем уникальный ключ, чтобы хеш-код был разным, при каждом запуске
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            SecretKey key = kgen.generateKey();

            //Хешируем строку s по формату sha256
            String sha256hex = Hashing.hmacSha256(key)
                    .hashString(s.toString(), StandardCharsets.UTF_8)
                    .toString();

            writer2.write(sha256hex);

            reader.close();
            writer2.close();
        } catch (IOException | NoSuchAlgorithmException e) {
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

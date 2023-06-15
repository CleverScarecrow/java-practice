package com.scarecrow.serialization.jdk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

/**
 * 序列化类没有指定serialVersionUID，会自动生成一个，但是如果类的内容发生变化，serialVersionUID也会发生变化，导致反序列化失败
 * 为了避免这种情况，可以自己指定serialVersionUID，但是要注意，如果类的内容发生变化，需要手动修改serialVersionUID
 */
public class TestJdkSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JdkUser user = new JdkUser();
        user.setUsername("test");
        user.setPassword("123");
        user.setAddress("beijing");
        serialize(user);
        JdkUser user2 = deserialize();
        System.out.println(user2);
    }

    public static void serialize(JdkUser user) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(new File("D:\\a.txt").toPath()));
        os.writeObject(user);
        os.close();
    }

    public static JdkUser deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream oi = new ObjectInputStream(Files.newInputStream(new File("D:\\a.txt").toPath()));
        return (JdkUser) oi.readObject();
    }

}

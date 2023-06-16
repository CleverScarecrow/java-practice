package com.scarecrow.serialization.hession;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * @author wangbo
 * @since 2023/6/16 11:03
 */
public class TestHessianSerializable {

    public static void main(String[] args) throws IOException {
        HessianUser user = new HessianUser();
        user.setUsername("test");
        user.setPassword(123);
        user.setAddress("beijing");

        byte[] serializeByteData = serialize(user);

        Object deserializeObjectData = deserialize(serializeByteData);
        System.out.println(deserializeObjectData);
    }

    public static <T> byte[] serialize(T obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(bos);
        try {
            ho.writeObject(obj);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        // 序列化文件里面包含 class全类名、属性字段类型及名称
        ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(new File("D:\\aa.txt").toPath()));
        os.write(bos.toByteArray());
        os.flush();
        return bos.toByteArray();
    }

    public static <T> Object deserialize(byte[] bytes) {
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        HessianInput hi = new HessianInput(is);
        try {
            return hi.readObject();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}

package com.scarecrow.concurrent.day03;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {

    /**
     * 使用hsdis工具查看汇编指令
     * VM参数：-server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*VolatileDemo.*
     * lock add dword ptr [rsp],0h  ;*putstatic stop; - com.scarecrow.gupao.day03.VolatileDemo::<clinit>@1 (line 7)
     *  volatile 修饰的成员变量时，会多一个 lock 指令
     */
    private volatile static boolean stop = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (stop) {
                i++;
            }
            //stop用volatile修饰，可以停止whie死循环
            System.out.println("child thread stop");
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        stop = false;
    }
}

package com.scarecrow.concurrent.day07;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

    private static DelayQueue<DelayedInteger> delayQueue = new DelayQueue<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            // 入队5个元素，每个延迟时间不同
            DelayedInteger myElement = new DelayedInteger(i, i * 10000);
            delayQueue.put(myElement);
        }
        while (true) {
            DelayedInteger element = delayQueue.take();
            System.out.println(element.getElement());
            if (delayQueue.size() == 0) {
                break;
            }
        }
    }

    static class DelayedInteger implements Delayed {

        private int element;

        private long expireTime;

        public DelayedInteger() {

        }

        public DelayedInteger(int element, long expireTime) {
            this.element = element;
            this.expireTime = System.currentTimeMillis() + expireTime;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(long expireTime) {
            this.expireTime = expireTime;
        }

        // 该方法返回当前元素还需要延迟多长时间，单位是纳秒
        @Override
        public long getDelay(TimeUnit unit) {
            //类里面接收的是毫秒，但是getDelay方法在DelayQueue里面传的是纳秒，所以这里需要进行一次单位转换
            return unit.convert(expireTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            // 这里的排序要确定最先到期的放在第一位，否则会阻塞住后面已经到期的
            return Long.valueOf(expireTime).compareTo(Long.valueOf(((DelayedInteger) o).getExpireTime()));
        }
    }
}

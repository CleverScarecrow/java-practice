package com.scarecrow.concurrent.day03;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.II_Result;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

/**
 * @author wangbo
 * @description
 * @date 2020/7/20
 */
// 指定使用并发测试
@JCStressTest
// 预测的结果与类型，附加描述信息
@Outcome(id = {"0, 1", "1, 0", "1, 1"}, expect = ACCEPTABLE, desc = "Trivial under sequential consistency")
@Outcome(id = "0, 0", expect = ACCEPTABLE_INTERESTING, desc = "Violates sequential consistency")
// 标注需要测试的类
@State
public class JcstressDemo {

    int a = 0, b = 0;

    // 标记方法使用多线程
    @Actor
    public void actor1(II_Result r) {
        r.r2 = a;
        b = 1;
    }

    @Actor
    public void actor2(II_Result r) {
        r.r1 = b;
        a = 1;
    }
}

package com.liangyuelong.blog.test;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomTest {

    @Test
    public void name() {
        System.out.println("hello world");
        System.out.println(Arrays.toString(random(10)));
        System.out.println(randomShuffle(10));

        long t = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            randomShuffle(1000);
        }
        t = System.currentTimeMillis() - t;
        System.out.println("ms:" + t);
        t = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            random(1000);
        }
        t = System.currentTimeMillis() - t;
        System.out.println(t);

    }

    public int[] random(int size) {
        int[] seed = new int[size];
        for (int i = 0; i < size; i++) {
            seed[i] = i;
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int r = RandomUtils.nextInt(0, size - i - 1);
            arr[i] = seed[r];
            seed[r] = seed[size - i - 1];
        }
        return arr;
    }

    public List<Integer> randomShuffle(int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

}

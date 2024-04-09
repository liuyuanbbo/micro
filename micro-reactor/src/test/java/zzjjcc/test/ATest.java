package zzjjcc.test;

import org.junit.jupiter.api.Test;

public class ATest {
    @Test
    public void test1() {

    }

    @Test
    public void testWhileTrue() {

    }

    private int get(int i){
        while (true){
            if (i==1000_000){
                return -1;
            }
        }
    }
}

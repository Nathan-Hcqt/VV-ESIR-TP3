package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

class StringUtilsTest {
    @Test
    void test1() {
        assertTrue(StringUtils.isBalanced("()"));
    }
    @Test
    void test2(){
        assertFalse(StringUtils.isBalanced("(hihi"));
    }
    @Test
    void test3(){
        assertFalse(StringUtils.isBalanced("hihi)"));
    }
    @Test
    void test4(){
        assertTrue(StringUtils.isBalanced("(hihi)"));
    }
    @Test
    void test5(){
        assertTrue(StringUtils.isBalanced("[(hihi)haha]"));
    }
    @Test
    void test6(){
        assertFalse(StringUtils.isBalanced("[(hihi)haha]}"));
    }
    @Test
    void test7(){
        assertFalse(StringUtils.isBalanced("[(hihi)haha}"));
    }
    @Test
    void test8(){
        assertFalse(StringUtils.isBalanced("[(hihi)haha)"));
    }
    @Test
    void test9(){
        assertFalse(StringUtils.isBalanced("{(hihi)haha]"));
    }
    @Test
    void test10(){
        assertTrue(StringUtils.isBalanced("{(hihi)haha}"));
    }
}
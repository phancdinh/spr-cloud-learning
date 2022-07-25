package com.example.ribbon;

import com.example.ribbon.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RibbonApplicationTests {

    @Autowired
    private StudentController studentController;
    @Test
    void contextLoads() {
    }

    @Test
    void checkCountDuplicateCharacters() {
        Map<Character, Integer> result = studentController.countDuplicateCharacters("phancongdinh");

        assertEquals(result.get("a".charAt(0)), 2);
    }
    @Test
    void checkCountDuplicateCharactersStr() {
        Map<Character, Long> result = studentController.countDuplicateCharactersStream("phancongdinh");

        assertEquals(result.get("a".charAt(0)), 2);
    }
    @Test
    void firstNonRepeatedCharacter() {
        char a = studentController.firstNonRepeatedCharacter("phancongdinh");

        assertEquals(a, "b".charAt(0));
    }
    @Test
    void firstNonRepeatedCharacterS() {
        String a = studentController.firstNonRepeatedCharacterStream("phancongdinh");
        assertEquals(a, "b");
    }
}

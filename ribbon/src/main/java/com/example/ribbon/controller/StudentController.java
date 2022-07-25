package com.example.ribbon.controller;

import com.example.ribbon.client.StudentUrlClient;
import com.example.ribbon.client.StudentUrlClient2;
import com.example.ribbon.dto.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private RestTemplate restTemplate;
    private StudentUrlClient studentUrlClient;
    private StudentUrlClient2 studentUrlClient2;

    public StudentController(RestTemplate restTemplate, StudentUrlClient studentUrlClient) {
        this.restTemplate = restTemplate;
        this.studentUrlClient = studentUrlClient;
    }

    @GetMapping(value = "/studentClient")
    public String studentClient() {
        return restTemplate.getForObject("http://student-producer/student", String.class);
    }

    @GetMapping(value = "/studentUrlClient")
    public StudentDto studentUrlClient() {
        return studentUrlClient.getStudent();
    }
    @GetMapping(value = "/studentUrlClient2")
    public StudentDto studentUrlClient2() {
        return studentUrlClient.getStudent();
    }

    public Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();
        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }
    public Map<Character, Long> countDuplicateCharactersStream(String str) {
        return str.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
    private static final int EXTENDED_ASCII_CODES = 256;
    public char firstNonRepeatedCharacter(String str) {

        int[] flags = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ?
            Character.MIN_VALUE : str.charAt(position);
    }
    public String firstNonRepeatedCharacterStream(String str) {

        Map<Integer, Long> chs = str.codePoints()
            .mapToObj(cp -> cp)
            .collect(Collectors.groupingBy(Function.identity(),
                LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
            .filter(e -> e.getValue() == 1L)
            .findFirst()
            .map(Map.Entry::getKey)
            .orElse((int) Character.MIN_VALUE);

        return String.valueOf(Character.toChars(cp));
    }
}

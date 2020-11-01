package com.company;

import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Algorithm", "Java", "Backend");
        stream.filter(s -> s.startsWith("A"))
                .peek(s -> System.out.println("A:" + s))
                .filter(s -> s.length() > 4)
                .peek(s -> System.out.println("B:" + s)).forEach(System.out::println);
    }
}

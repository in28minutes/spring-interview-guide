package com.in28minutes.springboot.basics.springbootin10steps;

public record Book(long id, String name, String author) {
    @Override
    public String toString() {
        return String.format("Book [id=%s, name=%s, author=%s]", id, name, author);
    }

}

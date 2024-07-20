package dk.johannes;

import dk.johannes.proto.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InitialPersonMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Person.Builder builder = Person.newBuilder();
        Person person1 = builder.setName("someName").setAge(25).build();
        serialize(person1);
        Person person2 = deserialize();

    }

    public static void serialize(Person person) throws IOException {
        person.writeTo(Files.newOutputStream(Path.of("this.thing")));
    }

    public static Person deserialize() throws IOException {
        Person person = Person.parseFrom(Files.readAllBytes(Path.of("this.thing")));
        return person;
    }
}
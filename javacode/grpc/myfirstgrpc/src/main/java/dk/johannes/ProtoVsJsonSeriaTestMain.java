package dk.johannes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import dk.johannes.proto.Person;

import java.io.IOException;

public class ProtoVsJsonSeriaTestMain {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args){

        Person protoPerson = Person.newBuilder().setName("name").setAge(25).build();
        JsonPerson jsonPerson = new JsonPerson("name", 25);

        testSerialization("Json", () -> serializeAndDeserializeJsonPerson(jsonPerson));
        testSerialization("Proto", () -> serializeAndDeserializeProtoPerson(protoPerson));

    }

    private static void serializeAndDeserializeJsonPerson(JsonPerson jsonPerson){
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(jsonPerson); //The bytes needed for JsonPerson are many more than for a protoperson.
            objectMapper.readValue(bytes, JsonPerson.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void serializeAndDeserializeProtoPerson(Person person) {
        try {
            byte[] byteArray = person.toByteArray();
            System.out.println("Protoperson bytesize:" + byteArray.length);
            Person.parseFrom(byteArray);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testSerialization(String testname, Runnable runnable) {
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++){
            runnable.run();
        }
        long endtime = System.currentTimeMillis();
        System.out.println(testname + " time taken: " + (endtime - starttime));
    }

}

record JsonPerson(String name, int age) {}

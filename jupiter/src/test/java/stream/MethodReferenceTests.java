package stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

// chap02
@Slf4j
public class MethodReferenceTests {

    @Test
    public void givenNewInstance_thenReferenceConstructorInFunction() {

    }

    @Test
    public void givenInstance_thenReferenceInFunction() {

    }

    @Test
    public void givenStringIndex_thenReferenceInFunction() {

    }

    @Test
    public void givenStaticMethod_thenReferenceInFunction() {

    }

    interface Greeting {
        String sayHello(String s1, String s2);
    }

    static class Player {
        static String sayHello(String s1, String s2) {
            return s1 + ": " + s2;
        }
    }
}

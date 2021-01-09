package stream;

import com.qyc.jupiter.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class OptionalStreamTests {

    private static final User[] arrayOfUsers = {
            User.builder().id(1L).username("zhangsan").name("张三").enabled(true).mobile("13000000001").build(),
            User.builder().id(2L).username("lisi").name("李四").enabled(false).mobile("13000000002").build(),
            User.builder().id(3L).username("wangwu").name("王五").enabled(true).mobile("13100000000").build(),
    };

    private MockRepo repo;

    @BeforeEach
    void setup() {
        repo = new MockRepo();
    }

    static class MockRepo {
        Optional<User> findByUsername(String username) {
            return Arrays.stream(arrayOfUsers)
                    .filter(user -> user.getUsername().equals(username))
                    .findAny();
        }
    }

    @Test
    public void givenUsers_whenQueryOptional_thenCheckPresent() {

    }

    @Test
    public void givenUsers_whenQueryEmpty_thenOrElseThrow() {

    }

    @Test
    public void givenUsers_whenQueryEmpty_thenOrElse() {

    }

    @Test
    public void givenUsers_whenQueryEmpty_thenOrElseGet() {

    }

    @Test
    public void givenUsers_whenQueryEmpty_thenOr() {
//
//        repo.findByUsername("zhaoliu")
//                .map(User::getUsername)
//                .or

    }

    @Test
    public void givenUsers_whenQuerying_thenIfPresent() {
        //当有值的时候执行
        repo.findByUsername("zhangsan")
                .map(User::getUsername)
                .ifPresent(username -> {
                    log.debug("username:{}",username);
                    assertEquals("zhangsan1",username);
                });
    }

    @Test
    public void givenUsers_whenQuerying_thenIfPresentOrElse() {
        repo.findByUsername("zhangsan")
                .map(User::getUsername)
                .ifPresent(username -> {
                    System.out.println("有值:"+username);
                });

    }

    @Test
    public void foreacheList(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,null);

        //old
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(item -> System.out.println(item));
        }

        //java 8
        Optional.ofNullable(list)
                .orElse(new ArrayList<>())
                .stream()
                .forEach(item -> {
                    System.out.println(item);
                });



    }
}

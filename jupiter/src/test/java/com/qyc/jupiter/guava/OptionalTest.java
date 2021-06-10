package com.qyc.jupiter.guava;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8中的Optional使用方法
 */
public class OptionalTest {

    @Test
    public void test() throws Throwable {
        /**
         * 三种创建Optional对象方式
         */

        // 创建空的Optional对象
        Optional.empty();

        // 使用非null值创建Optional对象
        Optional.of("zhangxiaoxi");

        // 使用任意值创建Optional对象
        Optional optional = Optional.ofNullable("zhangxiaoxi");

        /**
         * 判断是否引用缺失的方法(建议不直接使用)
         */
        optional.isPresent();

        /**
         * 当optional引用存在时执行
         * 类似的方法：map filter flatMap
         */
        optional.ifPresent(System.out::println);


        /**
         * 当optional引用缺失时执行
         */
        optional.orElse("引用缺失");
        optional.orElseGet(() -> {
            // 自定义引用缺失时的返回值
            return "自定义引用缺失";
        });
        optional.orElseThrow(() -> {
            throw new RuntimeException("引用缺失异常");
        });
    }

    public static void stream(List<String> list) {
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }


    /**
     * Option与stream结合
     * Optional.ofNullable  传入可以为空的对象
     */
    public static void streamListTest() {
//        List<String> list = Arrays.asList("1","2","3");
        List<String> list = Stream.of("1","2","3").collect(Collectors.toList());
        list= null;
//        list= new ArrayList<>();
        //这种方式list 为null会异常
//       list = Optional.of(list)
//               .get().stream()
//                .filter(item -> item.equals("3"))
//                .map(item -> item +"p")
//                .collect(Collectors.toList())
//                ;


        list = Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .filter(item -> item.equals("3"))
                .map(item -> item +"p")
                .collect(Collectors.toList())
        ;

        //测试findFirst
        String str = Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .findFirst()
                .orElse("ss");

        ;
        System.out.println(str);
        System.out.println(list);

    }

    public static void main(String[] args) {
        stream(null);
        streamListTest();
    }

}

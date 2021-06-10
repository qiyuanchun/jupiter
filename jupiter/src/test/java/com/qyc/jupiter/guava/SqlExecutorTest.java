package com.qyc.jupiter.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：mooc
 * <p>
 * *********************************
 *
 * <P>类名称：SqlExecutorTest</P>
 * *********************************
 *
 * <P>类描述：SqlExecutor测试类</P>
 * 创建人：zhangxiaoxi
 * <p>
 * 创建时间：2019/9/24 21:48
 * <p>
 * 修改备注：
 */
public class SqlExecutorTest {

    /**
     * 主方法
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        String[] strArr = new String[]{"yyyy-MM-dd HH:mm:ss"};

        // 构建原始集合数据
        List<Student> list = Lists.newArrayList();
        list.add(new Student(1, "唐一", "男", 11, DateUtils.parseDate("2018-01-01 00:00:00", strArr)));
        list.add(new Student(2, "杜二", "女", 12, DateUtils.parseDate("2018-02-02 00:00:00", strArr)));
        list.add(new Student(3, "张三", "男", 13, DateUtils.parseDate("2018-03-03 00:00:00", strArr)));
        list.add(new Student(4, "李四", "女", 14, DateUtils.parseDate("2018-04-04 00:00:00", strArr)));
        list.add(new Student(5, "王五", "女", 15, DateUtils.parseDate("2018-05-05 00:00:00", strArr)));

        // SQL语句
        String sql = "SELECT ID, NAME, AGE, BIRTHDAY FROM STUDENT WHERE AGE > 12 OR BIRTHDAY > '2018-04-04 00:00:00' ORDER BY ID DESC LIMIT 1, 2";

        // 使用SQL检索集合数据
        Object object = SqlExecutor.execute(Student.class, list, sql);

        // 输出结果
        System.out.println(JSON.toJSONString(object, true));
    }


    /**
     * STUDENT实体类
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Student {
        private Integer id;

        private String name;

        private String gender;

        private Integer age;

        private Date birthday;
    }
}
package com.yaojiafeng.springboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yaojiafeng.springboot.Application;
import com.yaojiafeng.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yaojiafeng
 * @since 2020/12/13 4:37 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryWrapper() {
        // Step1：创建一个 QueryWrapper 对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // Step2： 构造查询条件
        queryWrapper
                .select("id", "name", "age")
                .eq("age", 20)
                .like("name", "j");

        // Step3：执行查询
        userMapper
                .selectList(queryWrapper)
                .forEach(System.out::println);
    }

}

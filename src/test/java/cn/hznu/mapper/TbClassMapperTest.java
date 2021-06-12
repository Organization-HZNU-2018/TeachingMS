package cn.hznu.mapper;

import cn.hznu.pojo.TbStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TbClassMapperTest {
    @Autowired
    private TbStudentMapper studentMapper;

    @Autowired
    private TbAdminMapper adminMapper;

    @Test
    public void queryAllTest() {
        List<TbStudent> tbStudents = studentMapper.selectList(null);
        tbStudents.forEach(System.out::println);

        adminMapper.selectList(null).forEach(System.out::println);
    }
}
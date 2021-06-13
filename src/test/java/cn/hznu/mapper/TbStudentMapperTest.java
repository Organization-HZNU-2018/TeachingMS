package cn.hznu.mapper;

import cn.hznu.pojo.TbTeacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TbStudentMapperTest {

    @Autowired
    private TbTeacherMapper tbTeacherMapper;

    @Test
    public void selectById() {
        TbTeacher tbTeacher = tbTeacherMapper.selectById("T08005");
        System.out.println(tbTeacher);
    }

}
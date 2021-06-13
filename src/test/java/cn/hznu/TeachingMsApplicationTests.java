package cn.hznu;

import cn.hznu.mapper.TbClassMapper;
import cn.hznu.mapper.TbStudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class TeachingMsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TbClassMapper tbClassMapper;

    @Test
    public void TestGetClassInfoByDeptId() {
        List<Map<String, Object>> info = tbClassMapper.getClassInfoByDeptId(null);
        for (Map<String, Object> objectMap : info) {
            System.out.println(objectMap);
        }
    }

    @Autowired
    private TbStudentMapper tbStudentMapper;

    @Test
    public void TestGetClassInfoByDeptIdAndClassId() {
        List<Map<String, Object>> info = tbStudentMapper.getClassInfoByDeptIdAndClassId("02", "040201");
        for (Map<String, Object> objectMap : info) {
            System.out.println(objectMap);
        }
    }

}

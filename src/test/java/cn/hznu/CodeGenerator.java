
package cn.hznu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

// 代码自动生成器
public class CodeGenerator {
    public static void main(String[] args) {
        // 构建 代码自动生成器 对象
        AutoGenerator autoGenerator = new AutoGenerator();

        // 配置策略

        // 1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 输出路径
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        // 输出作者
        globalConfig.setAuthor("hznu");
        // 是否打开输出目录
        globalConfig.setOpen(false);
        // 是否覆盖已有文件
        globalConfig.setFileOverride(false);
        // 设置 service 文件名称方式
        globalConfig.setServiceName("%sService");
        // 设置主键生成策略
        globalConfig.setIdType(IdType.ASSIGN_ID);
        // 设置日期类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        // 设置开启 swagger2 模式
        globalConfig.setSwagger2(true);
        // 将全局配置放入 代码生成器 对象中
        autoGenerator.setGlobalConfig(globalConfig);

        // 2. 设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/DB_TeachingMS?serverTimezone=GMT%2B8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        // 将数据库配置放入代码生成器中
        autoGenerator.setDataSource(dataSourceConfig);

        // 3. 包的配置
        PackageConfig packageConfig = new PackageConfig();
        // packageConfig.setModuleName("code-generator");
        packageConfig.setParent("cn.hznu");
        packageConfig.setEntity("pojo");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        // 将包配置放入代码生成器中
        autoGenerator.setPackageInfo(packageConfig);

        // 4. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置命名格式为 下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动使用 Lombok
        strategy.setEntityLombokModel(true);
        // 设置要映射的表名
        /*strategy.setInclude("TB_Class");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Course");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_CourseClass");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Dept");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Grade");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_SelectCourse");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Spec");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Student");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Teacher");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_TeachingYear");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Term");  // 可变参数，多表直接夹在后面即可
        strategy.setInclude("TB_Title");  // 可变参数，多表直接夹在后面即可*/

        strategy.setInclude("TB_Admin");  // 可变参数，多表直接夹在后面即可

        // 开启 Rest 风格的驼峰命名
        strategy.setRestControllerStyle(true);
        // 设置请求链接下划线命名
        strategy.setControllerMappingHyphenStyle(true);

        // 将策略配置放入代码生成器中
        autoGenerator.setStrategy(strategy);

        // 生成
        autoGenerator.execute();
    }
}

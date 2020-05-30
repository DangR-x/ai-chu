package generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MybatisGenerator
 * @Description 执行生成Mybatis对应数据库的xml、Map、DO、DAO
 * @Author Melon
 * @Date 2019/7/18 16:09
 * @Version 1.0.0
 **/
public class MybatisGenerator {

    public static void main(String[] args) throws Exception {

        List<String> warnings = new ArrayList<String>();

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                MybatisGenerator.class.getResourceAsStream("/generatorConfig.xml")); // 生成mybatis的配置文件

        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println(warnings);
    }
}

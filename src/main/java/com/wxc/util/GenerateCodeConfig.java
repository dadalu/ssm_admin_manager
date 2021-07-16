package com.wxc.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author wangxiaocheng
 * @title: GenerateCodeConfig
 * @projectName bj-obd-heatmap-dpo
 * @description: TODO
 * @date 2021/7/5 17:02
 */
public class GenerateCodeConfig {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");  //生成路径(一般都是生成在此项目的src/main/java下面)
        gc.setAuthor("wangxiaocheng"); //设置作者
        gc.setOpen(false);
        gc.setFileOverride(true); //第二次生成会把第一次生成的覆盖掉
        gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有
        gc.setBaseResultMap(true); //生成resultMap
        mpg.setGlobalConfig(gc);

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/application?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useTimezone=true&serverTimezone=GMT%2B8&useUnicode=true&rewriteBatchedStatements=true&autoReconnect=true&autoReconnectForPools=true&failOverReadOnly=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 3、包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("com.china317.obd");
        pc.setParent("com.wxc");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.china317.obd.entity.IdEntity");
        strategy.setTablePrefix("sys_"); // 表名前缀
        strategy.setEntityLombokModel(true); //使用lombok
        String[] tables = {"sys_auth",
                "sys_auth_module",
                "sys_log",
                "sys_organization",
                "sys_orgnaization_role",
                "sys_orgnaization_user",
                "sys_role",
                "sys_role_auth",
                "sys_user",
                "sys_user_role"};
        strategy.setInclude(tables);  // 逆向工程使用的表   如果要生成多个,这里可以传入String[]
        mpg.setStrategy(strategy);

        //5、执行
        mpg.execute();
    }

}

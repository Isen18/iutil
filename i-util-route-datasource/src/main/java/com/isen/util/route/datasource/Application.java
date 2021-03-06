package com.isen.util.route.datasource;

import com.isen.util.route.datasource.service.UserService;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReport;
import org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReport.QueryStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Isen
 * @date 2019/4/18 22:07
 * @since 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
//@ImportResource(locations = "classpath:config/*")
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new SpringApplication(Application.class).run(args);
//        UserService userService = applicationContext.getBean(UserService.class);

//        User user = new User();
//        user.setName("isen");
//        userService.add(user);

//        User user = userService.queryPa(2L);
//        Assert.isTrue(user != null, "uid[2] = null");
//
//        User user2 = userService.queryPa(1L);
//        Assert.isTrue(user2 == null, "uid[1] != null");

//        testSlowQueryPlugin2(userService);
//        logger.info("ok");

        //打印sql语句的监控信息
//        String poolName = ((org.apache.tomcat.jdbc.pool.DataSource)applicationContext.getBean("slaveDataSource")).getPoolName();
//        printSQLInfo(poolName);
    }

    private static void printSQLInfo(String poolName){
        ConcurrentHashMap<String, QueryStats> map = SlowQueryReport.getPoolStats(poolName);
        logger.info(map.toString());
    }

    private static void testSlowQueryPlugin2(UserService userService){
//        userService.queryPa(2L);
//        userService.query2(2L);
        userService.query3(2L, "zhangsan");
        userService.query4(2L, "zhangsan");
//        // FIXME isen 2019/4/25 SlowQueryPlugin2有问题
        userService.query5(2L, "zhangsan");
    }
}

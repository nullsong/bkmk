package hu.bookmarker.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "hu.bookmarker")
@EnableTransactionManagement
public class MyBatisConfiguration {
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));

        // Set Mybatis Properties
        Properties mybatisProperties = new Properties();
        mybatisProperties.setProperty("lazyLoadingEnabled", "true");
       	mybatisProperties.setProperty("aggressiveLazyLoading", "false");
       	mybatisProperties.setProperty("lazyLoadTriggerMethods", "");
       	mybatisProperties.setProperty("mapUnderscoreToCamelCase", "true");
		mybatisProperties.setProperty("callSettersOnNulls", "true");
       	sessionFactory.setConfigurationProperties(mybatisProperties);

		return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().setCallSettersOnNulls(true);

        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

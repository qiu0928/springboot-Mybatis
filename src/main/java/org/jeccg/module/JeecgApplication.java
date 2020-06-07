package org.jeccg.module;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*@ComponentScan("org.jeccg.module")
@EnableAutoConfiguration*/
@SpringBootApplication
public class JeecgApplication {
  public static void main(String[] args){
    //System.setProperty("spring.devtools.restart.enabled", "true");
     SpringApplication.run(JeecgApplication.class, args);

  }

}
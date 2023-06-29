package com.ugurukku.generator.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
@Data
public class Repo {

    private final Map<Integer, String> dependencies = Map.of(
            1, """
                    <dependency>
                       <groupId>org.springframework.boot</groupId>
                       <artifactId>spring-boot-starter-data-jpa</artifactId>
                    </dependency>
                    """,
            2, """
                            <dependency>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-web</artifactId>
                            </dependency>
                    """,
            3, """
                            <dependency>
                                <groupId>com.h2database</groupId>
                                <artifactId>h2</artifactId>
                                <scope>runtime</scope>
                            </dependency>
                    """,
            4, """
                            <dependency>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                                <optional>true</optional>
                            </dependency>
                    """,
            5, """
                            <dependency>
                               <groupId>org.springdoc</groupId>
                               <artifactId>springdoc-openapi-ui</artifactId>
                               <version>1.6.14</version>
                            </dependency>
                    """,
            6, """
                        <dependency>
                          <groupId>com.mysql</groupId>
                          <artifactId>mysql-connector-j</artifactId>
                          <scope>runtime</scope>
                        </dependency>
                    """,
            7, """
                        <dependency>
                          <groupId>org.springframework.boot</groupId>
                          <artifactId>spring-boot-starter-mail</artifactId>
                        </dependency>
                    """,
            8, """
                        <dependency>
                          <groupId>org.springframework.boot</groupId>
                          <artifactId>spring-boot-starter-thymeleaf</artifactId>
                        </dependency> 
                    """,
            9, """
                        <dependency>
                          <groupId>org.springframework.boot</groupId>
                          <artifactId>spring-boot-starter-validation</artifactId>
                        </dependency>
                    """,
            10, """
                        <dependency>
                          <groupId>org.springframework.boot</groupId>
                          <artifactId>spring-boot-starter-security</artifactId>
                        </dependency>
                    """
    );

    private final String pomExample = """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
                        <modelVersion>4.0.0</modelVersion>
                        <parent>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-starter-parent</artifactId>
                            <version>{springVersion}</version>
                            <relativePath/> <!-- lookup parent from repository -->
                        </parent>
                        <groupId>{groupId}</groupId>
                        <artifactId>{artifact}</artifactId>
                        <version>0.0.1-SNAPSHOT</version>
                        <name>{name}</name>
                        <description>{description}</description>
                        <properties>
                            <java.version>{javaVersion}</java.version>
                        </properties>
                        <dependencies>
            {dependencies}
                        </dependencies>
                                
                        <build>
                            <plugins>
                                <plugin>
                                    <groupId>org.springframework.boot</groupId>
                                    <artifactId>spring-boot-maven-plugin</artifactId>
                                </plugin>
                            </plugins>
                        </build>
                    </project>
                    """;

}

package com.mysema.query.apt;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.mysema.query.apt.hibernate.HibernateAnnotationProcessor;
import com.mysema.query.apt.jdo.JDOAnnotationProcessor;
import com.mysema.query.apt.jpa.JPAAnnotationProcessor;

public class QuerydslAnnotationProcessorTest extends AbstractProcessorTest{

    private static final String packagePath = "src/test/java/com/mysema/query/domain/";

    @Test
    public void Process() throws IOException{
        File file = new File(packagePath, "AbstractEntityTest.java");
        process(QuerydslAnnotationProcessor.class, Collections.singletonList(file.getPath()),"qdsl");
    }
    
    @Test
    public void ProcessInheritance3() throws IOException{
        String path = new File("src/test/java/com/mysema/query/inheritance/Inheritance3Test.java").getPath();
        process(QuerydslAnnotationProcessor.class, Collections.singletonList(path),"inheritance3");
    }
    
    @Test
    public void ProcessInheritance8() throws IOException{
        String path = new File("src/test/java/com/mysema/query/inheritance/Inheritance8Test.java").getPath();
        process(QuerydslAnnotationProcessor.class, Collections.singletonList(path),"inheritance8");
    }

    @Test
    public void ProcessInheritance10() throws IOException{
        String path = new File("src/test/java/com/mysema/query/inheritance/Inheritance10Test.java").getPath();
        process(QuerydslAnnotationProcessor.class, Collections.singletonList(path),"inheritance10");
    }
    
    
    @Test
    public void ProcessAll() throws IOException{
        // works only in Eclipse for the moment
        List<String> classes = getFiles(packagePath);

        // default Processor
        process(QuerydslAnnotationProcessor.class, classes,"querydsl");

        // JPA
        process(JPAAnnotationProcessor.class, classes,"jpa");

        // Hibernate
        process(HibernateAnnotationProcessor.class, classes,"hibernate");

        // JDO
        process(JDOAnnotationProcessor.class, classes,"jdo");
    }
}

package com.rntgroup.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rntgroup.db.EventDatabase;
import com.rntgroup.db.TicketDatabase;
import com.rntgroup.db.UserDatabase;
import com.rntgroup.model.Entity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Map;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    private final ObjectMapper objectMapper = new ObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean + " start created with name " + beanName);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

//        if (beanClass.equals(EventDatabase.class)
//                || beanClass.equals(UserDatabase.class)
//                || beanClass.equals(TicketDatabase.class)) {
//            fillDatabase(bean);
//        }

        return bean;
    }

    private void fillDatabase(Object bean) {
        if (bean.getClass().equals(EventDatabase.class)) {
            dataSetter(bean, "eventDatabaseFilePath");
        }

        if (bean.getClass().equals(UserDatabase.class)) {
            dataSetter(bean, "userDatabaseFilePath");
        }

        if (bean.getClass().equals(UserDatabase.class)) {
            dataSetter(bean, "ticketDatabaseFilePath");
        }
    }

    private void dataSetter(Object bean, String filePath) {
        Field[] fields = bean.getClass().getDeclaredFields();

        Map<Long, ? extends Entity<Long>> data;

        try {
            data = objectMapper.readValue(
                    readResourceAsString(filePath),
                    new TypeReference<>() {
                    });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for (Field field : fields) {
            if (field.getName().equals("data")) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, data);
            }
        }
    }

    private String readResourceAsString(String filePath) {
        try {
            return Files.readString(new ClassPathResource(filePath).getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

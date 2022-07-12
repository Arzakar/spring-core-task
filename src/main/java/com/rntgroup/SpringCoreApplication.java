package com.rntgroup;

import com.rntgroup.facade.BookingFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        BookingFacade bookingFacade = context.getBean("bookingFacade", BookingFacade.class);
    }

}

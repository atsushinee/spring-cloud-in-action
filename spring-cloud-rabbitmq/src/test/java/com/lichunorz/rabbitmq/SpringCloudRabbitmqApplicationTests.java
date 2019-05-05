package com.lichunorz.rabbitmq;

import com.lichunorz.rabbitmq.producer.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudRabbitmqApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    private Sender sender;

    @Test
    public void hello() {
        sender.send();
    }
}

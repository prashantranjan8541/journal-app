package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Disabled
    public void testByUserName(){
//        return userRepository.findByUserName("Manshu1");
//        assertEquals(4,2+1);
        assertNotNull(userRepository.findByUserName("Manshu1"));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,1"
    })
    public void testParameter(int a , int b , int expected){
        assertEquals(expected,a + b);
    }
}

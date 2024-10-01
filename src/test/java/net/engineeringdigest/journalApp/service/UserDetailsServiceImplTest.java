package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // Use openMocks instead of initMocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadByUsernameTest() {
        // Mock your custom User entity
        User mockUserEntity = new User();
        mockUserEntity.setUserName("Ram");
        mockUserEntity.setPassword("89980jhjhj");
        mockUserEntity.setRoles(new ArrayList<>());

        // Mock the behavior of the repository
        when(userRepository.findByUserName(anyString())).thenReturn(mockUserEntity);

        // Call the service method
        UserDetails userDetails = userDetailsService.loadUserByUsername("Ram");

        // Validate the result
        assertNotNull(userDetails);
        verify(userRepository, times(1)).findByUserName("Ram");
    }
}

package com.didukh.service;

import com.didukh.service.controller.model.AdminModel;
import com.didukh.service.controller.model.UserModel;

import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static com.didukh.service.test.util.TestDataUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Hw3ApplicationTests {
    @Value("http://localhost:${local.server.port}/api/v1/users/")
    private String userUrl;

    @Value("http://localhost:${local.server.port}/api/v1/admin/")
    private String adminUrl;

    @Value(TEST_EMAIL)
    private String email;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void createUser() {
        UserDto userDto = new UserDto("1", "2", email, "123", "123", null);
        UserModel userModel = testRestTemplate.postForObject(userUrl, userDto, UserModel.class);
        assertEquals(userDto.getEmail(), userModel.getUserDto().getEmail());
    }


    @Test
    void createAdmin() {
        AdminDto adminDto = new AdminDto(email, PASSWORD, PASSWORD);
        AdminModel adminModel = testRestTemplate.postForObject(adminUrl, adminDto, AdminModel.class);
        assertEquals(adminModel.getAdminDto().getEmail(), email);
    }


    @Test
    void getUserTest() {
        UserModel userModel = testRestTemplate.getForObject(userUrl + email, UserModel.class);
        assertEquals(userModel.getUserDto().getEmail(), email);
    }

    @Test
    void getAdminTest() {
        AdminModel adminModel = testRestTemplate.getForObject(adminUrl + email, AdminModel.class);
        assertEquals(adminModel.getAdminDto().getEmail(), email);
    }
}

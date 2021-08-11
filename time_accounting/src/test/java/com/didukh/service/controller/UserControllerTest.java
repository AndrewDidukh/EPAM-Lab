package com.didukh.service.controller;

import com.didukh.service.controller.assembler.UserAssembler;
import com.didukh.service.controller.model.UserModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.service.UserService;
import com.didukh.service.test.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static com.didukh.service.test.util.TestDataUtil.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@Import({TestConfig.class})
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @MockBean
    private UserAssembler userAssembler;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUserTest() throws Exception {
        UserDto userDto = createUserDto();
        UserModel userModel = new UserModel(userDto);

        when(userService.getUser(TEST_EMAIL)).thenReturn(userDto);
        when(userAssembler.toModel(userDto)).thenReturn(userModel);

        mockMvc.perform(get("/api/v1/users/" + TEST_EMAIL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(TEST_EMAIL));
    }

    @Test
    void deleteUserTest() throws Exception {
        mockMvc.perform(delete("/api/v1/users/" + TEST_EMAIL))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    void getActivityTest() throws Exception {
        ActivityDto activityDto = createActivityDto();
        when(userService.getActivity(ACTIVITY_NAME)).thenReturn(activityDto);

        mockMvc.perform(get("/api/v1/users/" + ACTIVITY_NAME))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addActivityTimeTest() throws Exception {
        ActivityDto activityDto = createActivityDto();
        when(userService.addActivityTime(TEST_EMAIL, ACTIVITY_NAME, DURATION)).thenReturn(activityDto);

        mockMvc.perform(patch("/api/v1/users/" + TEST_EMAIL + "/" + ACTIVITY_NAME + "/addTime/" + DURATION + ""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void deleteActivityTest() throws Exception {
        mockMvc.perform(delete("/api/v1/users/" + TEST_EMAIL + "/" + ACTIVITY_NAME))
                .andDo(print())
                .andExpect(status().is(204));
    }

}

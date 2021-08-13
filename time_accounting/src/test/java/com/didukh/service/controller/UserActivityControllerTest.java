package com.didukh.service.controller;

import com.didukh.service.controller.assembler.UserActivityAssembler;
import com.didukh.service.service.UserService;
import com.didukh.service.test.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static com.didukh.service.test.util.TestDataUtil.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserActivityController.class)
@Import({TestConfig.class})
public class UserActivityControllerTest {

    @MockBean
    private UserService userService;

    @MockBean
    private UserActivityAssembler userActivityAssembler;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getActivity() throws Exception {
        when(userService.getActivity(TEST_EMAIL, ACTIVITY_NAME)).thenReturn(createUserActivityDto());

        mockMvc.perform(get("/api/v1/users/" + TEST_EMAIL + "/" + ACTIVITY_NAME))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addActivityTime() throws Exception {
        when(userService.getActivity(TEST_EMAIL, ACTIVITY_NAME)).thenReturn(createUserActivityDto());

        mockMvc.perform(patch("/api/v1/users/" + TEST_EMAIL + "/" + ACTIVITY_NAME + "/addTime/" + "/" + 10))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteActivity() throws Exception {
        mockMvc.perform(delete("/api/v1/users/" + TEST_EMAIL + "/" + ACTIVITY_NAME))
                .andDo(print())
                .andExpect(status().is(204));
    }
}

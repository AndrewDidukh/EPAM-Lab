package com.didukh.service.controller;

import com.didukh.service.controller.assembler.AdminActivityAssembler;
import com.didukh.service.dto.AdminActivityDto;
import com.didukh.service.model.enums.ActivityType;
import com.didukh.service.service.AdminService;
import com.didukh.service.test.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminActivityController.class)
@Import({TestConfig.class})
public class AdminActivityControllerTest {
    @MockBean
    private AdminService adminService;


    @MockBean
    private AdminActivityAssembler adminActivityAssembler;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllActivitiesTest() throws Exception {
        List<AdminActivityDto> list = new ArrayList<>();
        when(adminService.getUnacceptedActivities()).thenReturn(list);

        mockMvc.perform(get("/api/v1/admin/getAllActivities"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getUnacceptedActivitiesTest() throws Exception {
        List<AdminActivityDto> list = new ArrayList<>();
        when(adminService.getUnacceptedActivities()).thenReturn(list);

        mockMvc.perform(get("/api/v1/admin/getUnacceptedActivities"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getSortedActivitiesByNameTest() throws Exception {
        List<AdminActivityDto> list = new ArrayList<>();
        when(adminService.getSortedActivitiesByName()).thenReturn(list);

        mockMvc.perform(get("/api/v1/admin/getSortedActivitiesByName"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findAllByActivityTypeTest() throws Exception {
        List<AdminActivityDto> list = new ArrayList<>();
        when(adminService.findAllByActivityType(ActivityType.OTHER)).thenReturn(list);

        mockMvc.perform(get("/api/v1/admin/" + ActivityType.OTHER + "/findAllByActivityType"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

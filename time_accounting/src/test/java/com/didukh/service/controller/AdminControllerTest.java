package com.didukh.service.controller;


import com.didukh.service.controller.assembler.AdminAssembler;
import com.didukh.service.controller.assembler.UserAssembler;
import com.didukh.service.controller.model.AdminModel;
import com.didukh.service.dto.ActivityDto;
import com.didukh.service.dto.AdminDto;
import com.didukh.service.dto.UserDto;
import com.didukh.service.service.AdminService;
import com.didukh.service.test.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.didukh.service.test.util.TestDataUtil.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.didukh.service.test.util.TestDataUtil.createAdminDto;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminController.class)
@Import({TestConfig.class})
public class AdminControllerTest {
    @MockBean
    private AdminService adminService;

    @MockBean
    private AdminAssembler adminAssembler;

    @MockBean
    private UserAssembler userAssembler;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAdminTest() throws Exception {
        AdminDto adminDto = createAdminDto();
        AdminModel adminModel = new AdminModel(adminDto);

        when(adminService.getAdmin(TEST_EMAIL)).thenReturn(adminDto);
        when(adminAssembler.toModel(adminDto)).thenReturn(adminModel);

        mockMvc.perform(get("/api/v1/admin/" + TEST_EMAIL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(TEST_EMAIL));
    }

    @Test
    void acceptActivityTest() throws Exception {
        ActivityDto activityDto = createActivityDto();

        when(adminService.acceptActivity(TEST_EMAIL, ACTIVITY_NAME)).thenReturn(activityDto);

        mockMvc.perform(get("/api/v1/admin/accept/" + TEST_EMAIL + "/" + ACTIVITY_NAME))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

//    @Test
//    void getAllUsersTest() throws Exception {
//
//        List<UserDto> list = new ArrayList<>();
//        when(adminService.getAllUsers()).thenReturn(list);
//
//        mockMvc.perform(get("/api/v1/admin/getAllUsers"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }


}

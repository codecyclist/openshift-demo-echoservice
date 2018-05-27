package de.m9d.demos.openshiftechoservice;


import de.m9d.demos.openshiftechoservice.domain.Message;
import de.m9d.demos.openshiftechoservice.service.DeadMailboxService;
import de.m9d.demos.openshiftechoservice.web.UserInterfaceController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserInterfaceController.class)
public class UserInterfaceTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public DeadMailboxService deadMailboxService;


    @Test
    public void indexPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString("All your messages are belong to us.")));
    }

    @Test
    public void messagesPageShouldCallService() throws Exception {
        final String TOKEN = "Test title expected to be found";
        given(this.deadMailboxService.getMessages())
                .willReturn(Arrays.asList(new Message(TOKEN)));

        mockMvc.perform(get("/messages"))
                .andExpect(content().string(containsString(TOKEN)));
    }
}

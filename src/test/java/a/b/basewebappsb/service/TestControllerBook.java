package a.b.basewebappsb.service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.status;
@WebMvcTest(ControllerBook.class)
public class TestControllerBook {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testIndex() throws Exception {
        var expected = "This is the /book controller";

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString(expected)))
                .andExpect(content().contentTypeCompatibleWith( MediaType.TEXT_PLAIN));

    }
}

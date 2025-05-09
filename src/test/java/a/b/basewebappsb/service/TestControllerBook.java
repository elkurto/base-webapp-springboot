package a.b.basewebappsb.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import a.b.basewebappsb.domain.Book;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.
        MockMvcResultMatchers.status;
@WebMvcTest(ControllerBook.class)
public class TestControllerBook {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper = new ObjectMapper();

    @MockitoBean
    private ServiceBook serviceBook;

    @Test
    void testIndex() throws Exception {
        var expected = "This is the /book controller";

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString(expected)))
                .andExpect(content().contentTypeCompatibleWith( MediaType.TEXT_PLAIN));

    }

    @Test
    void testGetOneByUuid() throws Exception {
        // given
        UUID uuid = UUID.randomUUID();
        Book book = new Book(uuid, "foo","bar", 123456);

        when(serviceBook.get(uuid)).thenReturn(book);

        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/one/"+ uuid.toString()))
                .andExpect(status().isOk())
                ;

    }

}

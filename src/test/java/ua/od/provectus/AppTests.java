package ua.od.provectus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import ua.od.provectus.model.Book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void LibraryTest() throws Exception {
        mockMvc.perform(get("/user/library"))
                .andExpect(status().isOk());
    }

    @Test
    public void AddBookTest() throws Exception {
        mockMvc.perform(post("/admin/books/add")
                .param("title", "The Lord of the Rings")
                .param("description",
                        "Since it was first published in 1954, The Lord of the Rings has been a book people " +
                                "have treasured. Steeped in unrivalled magic and otherworldliness, " +
                                "its sweeping fantasy has touched the hearts of young and old alike.")
                .param("author", "R. R. Tolkien")
                .param("price", "1500")
                .param("genre", "Fantasy"))
                .andExpect(redirectedUrl("/admin/books"));

        // metod delete last book
    }
}

package cc.yuanspace.springboot.helloworld;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@AutoConfigureMockMvc
@SpringBootTest
public class AppTest {
    Logger log = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private HelloWorldController helloWorldController;

    @Test
    public void test() {
        System.out.println(helloWorldController.get());
    }

    /**
     * MockMvc 模拟调用controller的接口服务
     */
    @Autowired
    private MockMvc mvc;

    @Test
    public void mock() throws Exception {
        MvcResult mvcResult = null;
        mvcResult = mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, URI.create("/get"))
                .accept(MediaType.APPLICATION_JSON).param("aa", "123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

}

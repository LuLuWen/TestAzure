package demo2;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Demo2ApplicationTests {

	@Autowired
    private MockMvc mvc;
	
	@Autowired MemberAccount member;
	
	/*@Test
	public void postMemberTest() throws Exception{
		
		member = new MemberAccount(70 ,"testnew@gmail.com" ,"0912345678" ,"9999999" ,"新竹");
		
		mvc.perform(MockMvcRequestBuilders.post("/insert")
			.content(asJsonString(member))
			.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isCreated());
			//.andExpect((ResultMatcher) content().contentType("application/json;charset=UTF-8"));			
	}*/

	//Jackson ObjectMapper (Java Object to JSON)
	public static String asJsonString(final Object obj) {
		try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }		
	}
	
	/*@Test
	public void deleteMemberTest() throws Exception 
	{
	  mvc.perform(MockMvcRequestBuilders.delete("/member/delete/{id}", 229) )
	        .andExpect(status().isAccepted());
	}*/
	
	@Test
	public void listAllMemberTest() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/member/listAll")
	      .accept(MediaType.APPLICATION_JSON_VALUE))
	      .andDo(print())
	      .andExpect(status().isOk())
	      //.andExpect(jsonPath("$", hasSize(2)))
	      .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(92))
	      //.andExpect(MockMvcResultMatchers.jsonPath("$[].cellphone").value("0912345789"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("888888"));
	      //.andExpect(MockMvcResultMatchers.jsonPath("$[*].Id").isEmpty());
	}
	
	/*@Test
	public void listByIdTest() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/member/listByID/{id}", 202)
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").hasJsonPath())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(5));
	}*/

	/*@Test
	public void updateTest() throws Exception 
	{
	  member = new MemberAccount(230,"test@gmail.com" ,"test" ,"test" ,"test");
		
	  mvc.perform( MockMvcRequestBuilders
	      .put("/member/update/{id}", 230)
	      .content(asJsonString(member))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(230))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@gmail.com"))
	      .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("test"));
	}*/
}

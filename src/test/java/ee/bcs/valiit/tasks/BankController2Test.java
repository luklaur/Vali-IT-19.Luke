package ee.bcs.valiit.tasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BankController2Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createCustomer() throws Exception {
//        http://localhost:8080/bank2/createCustomer?firstname=Jaanus&lastname=Redis&address=Kõrgemäe 5
        mockMvc.perform(get("/bank2/createCustomer?firstname=Jaanus&lastname=Redis&address=Kõrgemäe 5")
                .contentType("application / json"))
                .andExpect(status().isOk());
    }

    @Test
    void createAccount() throws Exception {
//        http://localhost:8080/bank2/createAccount?accountNr=EE126&customer_id=3
        mockMvc.perform(get("/bank2/createAccount?accountNr=EE126&customer_id=3")
                .contentType("application / json"))
                .andExpect(status().isOk());
    }

    @Test
    void accountBalance() throws Exception {
//        http://localhost:8080/bank2/accountBalance?accountNr=EE123
        mockMvc.perform(get("/bank2/accountBalance?accountNr=EE123")
                .contentType("application / json"))
                .andExpect(status().isOk());
    }

    @Test
    void depositMoney() throws Exception {
//        http://localhost:8080/bank2/depositMoney?accountNr=EE125&amount=600
        mockMvc.perform(get("/bank2/depositMoney?accountNr=EE125&amount=600")
                .contentType("application / json"))
                .andExpect(status().isOk());
    }

    @Test
    void withdrawMoney() throws Exception {
//        http://localhost:8080/bank2/withdrawMoney?accountNr=EE123&amount=50
        mockMvc.perform(get("/bank2/withdrawMoney?accountNr=EE123&amount=50")
                .contentType("application / json"))
                .andExpect(status().isOk());
    }

    @Test
    void transferMoney() throws Exception {
//        http://localhost:8080/bank2/transferMoney?fromAccount=EE125&toAccount=EE123&amount=134
        mockMvc.perform(get("/bank2/transferMoney?fromAccount=EE125&toAccount=EE123&amount=134")
                .contentType("application / json"))
                .andExpect(status().isOk());
    }
}
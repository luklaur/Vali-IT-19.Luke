package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("tasks")
@RestController
public class EmployeeController {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

//    HashMap<String, String> employee = new HashMap<>();


    // http://localhost:8080/tasks/employee?name=Roobert&address=Narva_7
    @PostMapping("employee")
    public String employee(@RequestParam("name") String name,
                           @RequestParam("address") String address) {
        String sql = "INSERT INTO employee (name, address) VALUES (:nameParameter, :addressParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("nameParameter", name);
        paramMap.put("addressParameter", address);
        jdbcTemplate.update(sql, paramMap);
        return "Uus töötaja lisatud";
    }

}


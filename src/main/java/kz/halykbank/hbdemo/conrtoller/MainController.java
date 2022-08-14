package kz.halykbank.hbdemo.conrtoller;

import kz.halykbank.hbdemo.domain.Users;
import kz.halykbank.hbdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody Users addNewUser (@RequestParam Integer per_num, @RequestParam String fio, @RequestParam String birth_date,  @RequestParam String role) {

        Users user = new Users();
        user.setFio(fio);
        user.setBirth_date(birth_date);
        user.setPer_num((per_num));
        user.setRole(role);
        userRepository.save(user);
        return user;

    }

    @GetMapping("/{per_num}")
    public @ResponseBody Iterable<Users> getUsers(@PathVariable Integer per_num) {

        if(per_num == 0){
            return userRepository.findAll();
        }else{
            return userRepository.findByPerNum(per_num);
        }
    }
}

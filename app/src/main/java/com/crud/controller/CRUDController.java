package com.crud.controller;

import com.crud.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/")
public class CRUDController
{
    List<User> userList = new ArrayList<User>();
//    Map<Long,User> map = new HashMap<Long,User>();

    static long id = 1;

    @RequestMapping(path="/adduser" , method= RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> adduser(@RequestBody User user)
    {
//        User user2 = new User(user.getName(),user.getAge(),user.getGender(),user.getDob(),user.getMobile(),user.getEmail(),user.getPassword());
        System.out.println(user.getName());
        System.out.println(user.getAge());

       // System.out.println(user.getCpassword());
        user.setId(id);
        System.out.println(user.getId());
        userList.add(user);
        id++;
        return userList;
    }

    @GetMapping("/showuserbyname/{name}")
    public List<User> showUser(@PathVariable("name") String name)
    {
        System.out.println(name);
        return userList;
    }

    @GetMapping("/showusers")
    public List<User> showAllUsers()
    {
        return userList;
    }

//    @GetMapping("/del")
//    public String del(Model model)
//    {
//        model.addAttribute("ulist",userList);
//        return "deleteusers";
//    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id)
    {
        for( User user : userList )
        {
            if( user.getId() == id )
            {
                userList.remove(user);
                break;
            }
        }
    }

//    @GetMapping("/update")
//    public String update()
//    {
//        return "form";
//    }

    @RequestMapping(path="/updateuser" , method= RequestMethod.PATCH)
    public User updateUser(@RequestBody User user)
    {
        System.out.println(user);
        User updated=null;
        for( User temp : userList )
        {
            if( temp.getId() == user.getId() )
            {
                updated = temp;
                break;
            }
            System.out.println("for loop end");
        }
        userList.remove(updated);
        System.out.println("outside for"+updated);
        updated.setName(user.getName());
        updated.setAge(user.getAge());
        updated.setGender(user.getGender());
        updated.setDob(user.getDob());
        updated.setMobile(user.getMobile());
        updated.setEmail(user.getEmail());
        userList.add(updated);
        System.out.println("updated"+updated);
        return updated;
    }
}
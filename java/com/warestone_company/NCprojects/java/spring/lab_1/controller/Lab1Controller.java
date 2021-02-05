package com.warestone_company.NCprojects.java.spring.lab_1.controller;

import com.warestone_company.NCprojects.java.spring.lab_1.ioFile.ReadFile;
import com.warestone_company.NCprojects.java.spring.lab_1.ioFile.WriteFile;
import com.warestone_company.NCprojects.java.spring.lab_1.model.AddUser;
import com.warestone_company.NCprojects.java.spring.lab_1.model.FoundedUser;
import com.warestone_company.NCprojects.java.spring.lab_1.model.RequestInfo;
import com.warestone_company.NCprojects.java.spring.lab_1.model.SearchUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class Lab1Controller {

    @Autowired
    private JavaMailSender javaMailSender;
    private final AddUser addUser = new AddUser();
    private final Logger logger = Logger.getLogger(Lab1Controller.class.getName());
    private boolean clearUser;
    private boolean clearSearchResults;
    private List<FoundedUser> foundedUsersList = new ArrayList<>();
    private RequestInfo requestInfo = new RequestInfo();

    @GetMapping("/surprise")
    public String getSurprisePage() {
        logger.log(Level.INFO, "surprise.html has been called.");
        return "surprise";
    }

    @GetMapping("/userNotFound")
    public String getUserNotFoundPage() {
        logger.log(Level.INFO, "userNotFound.html has been called.");
        return "userNotFound";
    }

    @GetMapping("/add")
    public String getAddUserPage(Model model) {
        if (clearUser)addUser.clear();
        clearUser = false;
        model.addAttribute("addUser", addUser);
        logger.log(Level.INFO, "add.html has been called.");
        return "add";
    }

    @GetMapping("/search")
    public String getSearchUserPage(Model model){
        if (clearSearchResults)
        {
            foundedUsersList.clear();
            requestInfo.clear();
        }
        model.addAttribute("usersList", foundedUsersList);
        model.addAttribute("searchUser", new SearchUser());
        model.addAttribute("requestInfo", requestInfo);
        logger.log(Level.INFO, "search.html has been called.");
        clearSearchResults = true;
        return "search";
    }

    @PostMapping(value = "/upload")
    public RedirectView readFile(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty() || file.getName().endsWith(".txt")) {
            try {
                parseFileToAddUser(new String(file.getBytes(), StandardCharsets.UTF_8));
                logger.log(Level.INFO, "file " + file.getName() + " successfully read");
            } catch (IOException e) {
                logger.log(Level.WARNING, "Error with read " + file.getName() + " file.\nError message: " + e.getMessage());
            }
        }
        return new RedirectView("/add");
    }

    @PostMapping(value = "/add")
    public String checkUserInfoAndGetResult(@Valid AddUser addUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            logger.log(Level.WARNING, "incorrect input in add.html.");
            return "add";
        }
        else{
            model.addAttribute("add", addUser);
            new WriteFile(addUser.toString(),logger);
            logger.log(Level.INFO, "result.html has been called.");
            clearUser = true;
            return "result";
        }
    }

    @PostMapping(value = "/search")
    public RedirectView checkNameUserAndFindInUsers(SearchUser searchUser, HttpServletRequest request){
        ArrayList<String>allUsers = new ReadFile().readUsersFile(logger);
        if (allUsers == null){
            return new RedirectView("/userNotFound");
        }
        for (String founded:allUsers){
            String[]user = founded.split("\\|");
            if (user[0].equals(searchUser.getLastName()) && user[1].equals(searchUser.getFirstName())){
                foundedUsersList.add(
                        new FoundedUser(user[0],user[1],user[2],
                                user[3],user[4],
                                Short.parseShort(user[5]),Double.parseDouble(user[6]))
                );
            }
        }
        if (foundedUsersList.size()==0) return new RedirectView("/userNotFound");
        else{
            clearSearchResults = false;
            requestInfo.setBrowser(request.getHeader("user-agent"));
            requestInfo.setTime(new Date().toString());
            return new RedirectView("/search");
        }
    }

    @PostMapping(value = "/sentMessage")
    public RedirectView sentMessageToPost(SearchUser searchUser){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(searchUser.getEmail());
        message.setFrom("donttryreply@skynet.mil");
        message.setSubject("Mail from skynet military systems");
        message.setText(searchUser.getMessage());
        javaMailSender.send(message);
        logger.info("message successfully sent to "+searchUser.getEmail());
        return new RedirectView("/search");
    }

    private void parseFileToAddUser(String text){
        String[] lines = text.split("\\r\\n");
        if (lines.length==7){
            addUser.setFirstName(lines[0]);
            addUser.setLastName(lines[1]);
            addUser.setPatronymicName(lines[2]);
            addUser.setAge(Short.parseShort(lines[3]));
            addUser.setEmail(lines[4]);
            addUser.setSalary(Double.parseDouble(lines[5]));
            addUser.setWorkAddress(lines[6]);
        }
        else logger.log(Level.WARNING, "File has incorrect information, parse abort.");
    }
}

package com.iutlibrary.backend.appUserDetails;


import com.iutlibrary.backend.utility.enums.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(maxAge = 3600)
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/admin/all")
    public List<Account> getAllAdmins(){
        return accountService.findAllByRole(AppUserRole.ADMIN);
    }

    @GetMapping("/student/all")
    public List<Account> getAllStudents(){
        return accountService.findAllByRole(AppUserRole.STUDENT);
    }

    @GetMapping("/librarian/all")
    public List<Account> getAllLibrarians(){
        return accountService.findAllByRole(AppUserRole.LIBRARIAN);
    }

    @GetMapping("/student")
    public Account getOneStudent(@RequestParam(name = "studentId") String studentId){
        return accountService.findByMemberId(studentId);
    }

    @GetMapping("/librarian")
    public Account getOneLibrarian(@RequestParam(name = "librarianId") String librarianId){
        return accountService.findByMemberId(librarianId);
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<Object> deleteAccount(@RequestParam(name = "memberId") String memberId){
        return accountService.deleteAccount(memberId);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<Object> addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }


}

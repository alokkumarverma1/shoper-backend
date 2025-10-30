package com.example.user_service.security;

import com.example.user_service.entity.Register;
import com.example.user_service.repo.Registerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.Region;
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private Registerrepo registerrepo;

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        Register register =registerrepo.findByNumber(Long.parseLong(number));
        if(register == null){
            throw new UsernameNotFoundException(number + " not found");
        }

        return new UserDetail(register);
    }
}

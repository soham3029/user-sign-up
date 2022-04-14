package com.example.soham.usersignup.serviceimpl;

import com.example.soham.usersignup.dao.UserDAO;
import com.example.soham.usersignup.model.User;
import com.example.soham.usersignup.requestbody.UserRequest;
import com.example.soham.usersignup.responsebody.Errorresponse;
import com.example.soham.usersignup.responsebody.UserResponse;
import com.example.soham.usersignup.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserResponse createUser(UserRequest user) {
        UserResponse userResponse = new UserResponse();
        User os = new User();
        Errorresponse errorresponse = validateUser(user);
        if(errorresponse != null){
            userResponse.setMessage("User Creation failed");
        }
        else {
            os.setUserId(user.getUserDto().getUserId());
            os.setFirstName(user.getUserDto().getFirstName());
            os.setLastName(user.getUserDto().getLastName());
            os.setEmail(user.getUserDto().getEmail());
            os.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getUserDto().getPassword()));
            User storedUserDetails = userDAO.save(os);
            BeanUtils.copyProperties(storedUserDetails, userResponse);
            userResponse.setMessage("User creation success");
        }
        return userResponse;
    }
    public Errorresponse validateUser(UserRequest user)
    {
        Errorresponse response = new Errorresponse();
        User os = userDAO.getUserByEmail(user.getUserDto().getEmail());
        if(user.getUserDto().getEmail() == null)
        {
            response.setStatusCode(403);
            response.setMessage("Please enter a email");
            return response;
        }
        else if(os != null)
        {
            response.setStatusCode(401);
            response.setMessage("Email already exists");
            return response;
        }
        else if(user.getUserDto().getPassword() == null)
        {
            response.setStatusCode(404);
            response.setMessage("Please enter a password");
            return response;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

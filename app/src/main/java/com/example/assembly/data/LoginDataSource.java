package com.example.assembly.data;

import com.example.assembly.ResponseTask;
import com.example.assembly.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser loggedin_user =
                    new LoggedInUser(
                            new ResponseTask().execute("http://209.250.237.51:3000/login","email",username,"password",password).get());
            return new Result.Success<>(loggedin_user);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}

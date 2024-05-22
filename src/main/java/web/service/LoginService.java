package web.service;

public class LoginService {
    public boolean login(String username, String password, String dob) {

        if ("admin".equals(username) && "admin".equals(password) && "1990-01-01".equals(dob)) {
            return true;
        }
        return false;
    }
}

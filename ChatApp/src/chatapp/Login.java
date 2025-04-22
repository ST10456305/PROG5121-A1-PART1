package chatapp;


public class Login {
    
    // Instance Variables
    private String registeredUsername;
    private String registeredPassword;
    private String registeredPhone;

    //Username Checker
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    //Password Checker
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*[a-zA-Z0-9].*")) return false;
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) return false;
        return true;
    }
    // AI Recommended Cellphone Checker
    public boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }
    // User Registration
    public String registerUser(String username, String password, String phone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(phone)) {
            return "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }

        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredPhone = phone;

        return "User registered successfully.";
    }
    // User Login
    public boolean loginUser(String username, String password) {
        return this.registeredUsername != null && this.registeredUsername.equals(username)
                && this.registeredPassword.equals(password);
    }
    // User Logout
    public String returnLoginStatus(boolean status, String firstName, String lastName) {
        return status ? "Welcome " + firstName + " " + lastName + ", it is great to see you again."
                      : "Username or password incorrect, please try again.";
    }
}

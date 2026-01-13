package InputValidation;

public class RegexValidation {
    
    // Method to validate mobile number
    public void validateMobile(String mobile) throws InvalidInputException {
        // Example: 10 digits, optional country code (+91)
        String regex = "^(\\+\\d{1,3})?\\d{10}$";
        if (!mobile.matches(regex)) {
            throw new InvalidInputException("Invalid Mobile Number!");
        }
        System.out.println("Mobile Number is valid. Welcome!");
    }

    // Method to validate email
    public void validateEmail(String email) throws InvalidInputException {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!email.matches(regex)) {
            throw new InvalidInputException("Invalid Email ID!");
        }
        System.out.println("Email ID is valid. Welcome!");
    }

    // Method to validate username
    public void validateUsername(String username) throws InvalidInputException {
        // Username: 5-15 characters, letters, numbers, underscores
        String regex = "^[a-zA-Z0-9_]{5,15}$";
        if (!username.matches(regex)) {
            throw new InvalidInputException("Invalid Username!");
        }
        System.out.println("Username is valid. Welcome!");
    }

    // Method to validate password
    public void validatePassword(String password) throws InvalidInputException {
        // Password: Minimum 8 chars, at least 1 uppercase, 1 lowercase, 1 digit, 1 special char
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!^&*])[A-Za-z\\d@#$%!^&*]{8,}$";
        if (!password.matches(regex)) {
            throw new InvalidInputException("Invalid Password!");
        }
        System.out.println("Password is valid. Welcome!");
    }

   }
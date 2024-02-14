package org.example;

public class UserService {
    public int getUserScore(String[] records, String email) throws UserNotFoundException {
        String score = null;
        for (String record : records) {
            String[] recordParts = record.split(":");
            if (recordParts[0].equals(email)) {
                score = recordParts[1];
                break;
            }
        }
        if (score != null) {
            return Integer.parseInt(score);
        } else {
            throw new UserNotFoundException("User with given email doesn't exist");
        }
    }
}

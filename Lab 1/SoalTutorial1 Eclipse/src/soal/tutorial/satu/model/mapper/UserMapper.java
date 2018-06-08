package soal.tutorial.satu.model.mapper;

import soal.tutorial.satu.model.User;

/**
 * Created by agungwb on 11/02/2017.
 */
public interface UserMapper {

    public User getUserByUsername(String username);
    public User getPenggunaByUsernameAndHashedPassword(String username, String hashedPassword);

}

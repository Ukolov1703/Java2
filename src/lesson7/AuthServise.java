package lesson7;

import java.util.List;

public interface AuthServise {
    void start();
    String getNickyLoginPass(String login, String pass);
    void stop();
}



package yingdg.exercise.basic.objects;

import com.google.common.base.Objects;

/**
 * Created by YingDG on 2017/2/4.
 */
public class User {
    private String username;
    private String password;
    private int age;

    public User() {

    }

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        // 类已过时，不建议使用
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("username", username)
                .add("password", password)
                .add("age", age)
                .toString();
    }
}

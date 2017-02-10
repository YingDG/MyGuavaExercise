package yingdg.exercise.basic.comparisonchain;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * Created by YingDG on 2017/2/4.
 */
public class User implements Comparable<User> {
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


    @Override
    public int compareTo(User that) {
        return ComparisonChain.start()
                .compare(this.username, that.username)
                .compare(this.age, that.age)
                .result();
    }
}

package rxsample;

import java.util.List;

/**
 * Created by hyunji on 16. 7. 14..
 */
public class Issue {

    private final String title;
    private final String body;
    private final User user;
    private final List<Label> labels;


    public Issue(String title, String body, User user, List<Label> labels) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.labels = labels;
    }
}

class User {
    private final String login;

    public User(String login) {
        this.login = login;
    }
}

class Label {
    private final String name;
    private final String color;

    public Label(String name, String color) {
        this.name = name;

        this.color = color;
    }
}

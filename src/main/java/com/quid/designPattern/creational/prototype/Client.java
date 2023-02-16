package com.quid.designPattern.creational.prototype;

import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void prototype() throws CloneNotSupportedException {
        Repository repository = new Repository("quid", "quid");
        Issue issue = new Issue(repository);
        issue.makeIssue("url", "title");

        Issue issue2 = (Issue) issue.clone();
        issue2.makeIssue("url2", "title2");

    }
}

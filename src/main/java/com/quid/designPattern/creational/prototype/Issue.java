package com.quid.designPattern.creational.prototype;

public class Issue implements Cloneable {

    private final Repository repository;
    private String url;
    private String title;

    public Issue(Repository repository) {
        this.repository = repository;
    }

    public void makeIssue(String url, String title) {
        this.url = url;
        this.title = title;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Repository repository = new Repository(this.repository.getName(),
            this.repository.getPassword());
        Issue issue = new Issue(repository);
        issue.makeIssue(this.url, this.title);
        return issue;
    }
}
package com.quid.designPattern.structural.decorator;

public interface CommentService {

    void addComment(String comment);

    class DefaultCommentService implements CommentService {

        @Override
        public void addComment(String comment) {
            System.out.println("Comment added: " + comment);
        }
    }

}

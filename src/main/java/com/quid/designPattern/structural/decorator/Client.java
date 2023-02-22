package com.quid.designPattern.structural.decorator;

import com.quid.designPattern.structural.decorator.CommentService.DefaultCommentService;
import com.quid.designPattern.structural.decorator.commentDecorator.SpamFilteringCommentDecorator;
import com.quid.designPattern.structural.decorator.commentDecorator.TrimmingCommentDecorator;
import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void decorator() {
        CommentService commentService = new DefaultCommentService();

        commentService = new TrimmingCommentDecorator(commentService);
        commentService = new SpamFilteringCommentDecorator(commentService);

        commentService.addComment("  Hello world!  ");
        commentService.addComment("  http://www.google.com  ");
    }
}


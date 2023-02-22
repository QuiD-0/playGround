package com.quid.designPattern.structural.decorator.commentDecorator;

import com.quid.designPattern.structural.decorator.CommentService;

public class TrimmingCommentDecorator extends CommentDecorator {

    public TrimmingCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        super.addComment(comment.trim());
    }
}


package abdul.api.controller;

import abdul.api.model.Label;
import abdul.api.model.Post;
import abdul.api.model.PostStatus;
import abdul.api.service.PostService;

import java.util.Date;
import java.util.List;

public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public Post createPost(String content, Date created, Date updated, List<Label> labels) {
        Post postSave = new Post(content, created, updated, labels);
        postSave.setPostStatus(PostStatus.ACTIVE);
        return postService.savePost(postSave);
    }

    public void updatePost(Post postUpdate) {
        postUpdate.setPostStatus(PostStatus.UNDER_REVIEW);
        postService.updatePost(postUpdate);
    }

    public void deletePost(int id) {
        postService.deletePost(id);
    }

    public Post getByIdPost(int id) {
        return postService.getByIdPost(id);
    }
}

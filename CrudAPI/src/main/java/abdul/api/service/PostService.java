package abdul.api.service;

import abdul.api.model.Post;
import abdul.api.repository.PostRepository;
import abdul.api.repository.repositoryImpl.HibernatePostRepositoryImpl;

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostService() {
        this.postRepository = new HibernatePostRepositoryImpl();
    }


    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void updatePost(Post post) {
        postRepository.update(post);
    }

    public void deletePost(int id) {
        postRepository.delete(id);
    }

    public Post getByIdPost(int id) {
        return postRepository.getById(id);
    }
}

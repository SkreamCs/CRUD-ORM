package abdul.api.test;


import abdul.api.model.Post;
import abdul.api.model.PostStatus;
import abdul.api.repository.PostRepository;
import abdul.api.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.sql.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

        @Mock
        PostRepository postRepository;
        @InjectMocks
        PostService postService;
        @Test
        public void createPostTest() {
            Post postExpected = new Post("hard", Date.valueOf("2024-1-1"), Date.valueOf("2024-1-1"), List.of(new abdul.api.model.Label("Name")));
            postExpected.setPostStatus(PostStatus.ACTIVE);

            when(postRepository.save(postExpected)).thenReturn(postExpected);

            Post savePost = postService.savePost(postExpected);

            Assertions.assertEquals(postExpected,savePost);
        }
        @Test
        public void updatePostTest() {
            Post post = new Post("hard", Date.valueOf("2024-1-1"), Date.valueOf("2024-1-1"), List.of(new abdul.api.model.Label("Name")));
            post.setPostStatus(PostStatus.ACTIVE);

            postService.updatePost(post);

            verify(postRepository, times(1)).update(post);
        }
        @Test
        public void getByIdPostTest() {
            Post postExpected = new Post("hard", Date.valueOf("2024-1-1"), Date.valueOf("2024-1-1"), List.of(new abdul.api.model.Label("Name")));
            postExpected.setPostStatus(PostStatus.ACTIVE);
            postExpected.setId(1);

            when(postRepository.getById(1)).thenReturn(postExpected);

            Post postActual = postService.getByIdPost(1);

            Assertions.assertEquals(postExpected, postActual);
        }
        @Test
        public void deletePostTest() {
            int id = 1;

            postService.deletePost(id);

            verify(postRepository, times(1)).delete(id);
        }
    }



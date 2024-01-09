create table post_labels(
                      post_id int,
                      label_id int,
                      CONSTRAINT fk_post_id FOREIGN KEY (post_id) references posts(id),
                      CONSTRAINT fk_label_id FOREIGN KEY (label_id) references labels(id),
                      CONSTRAINT post_labels_pkey PRIMARY KEY (post_id, label_id)
);
create table posts(
                        id serial,
                        content character varying(45),
                        created character varying(45),
                        updated character varying(45),
                        status  character varying(45),
                        writer_id int,
                        CONSTRAINT post_pkey FOREIGN KEY (writer_id) references writers(id),
                        PRIMARY KEY (id)
);
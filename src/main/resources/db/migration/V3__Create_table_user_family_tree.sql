create table if not exists person_service.user_family_tree
(
    id        serial primary key,
    parent_id integer,
    user_id   integer,
    created_on    timestamp without time zone,
    update_on     timestamp without time zone
)

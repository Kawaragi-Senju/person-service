create table if not exists person_service.users
(
    id            serial primary key,
    fio           varchar,
    login         varchar,
    email         varchar,
    date_of_birth timestamp without time zone,
    created_on    timestamp without time zone,
    update_on     timestamp without time zone
)
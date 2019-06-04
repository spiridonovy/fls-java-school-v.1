create table public.doctor
(
    id serial not null,
    name varchar not null
);

create table public.patient
(
    id serial not null,
    name varchar not null,
    sex varchar
);

create table public.room
(
    id serial not null,
    name varchar not null
);

create table public.study
(
    id serial not null,
    description varchar not null,
    status varchar not null,
    planned_start_time date not null,
    estimated_end_time date
);



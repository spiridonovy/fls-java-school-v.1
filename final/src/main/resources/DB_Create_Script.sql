create database postgres
  with owner postgres;

comment on database postgres is 'default administrative connection database';

create table patient
(
  id         serial not null
    constraint patient_pk
      primary key,
  name       char(100),
  sex        integer,
  dayofbirth date
);

alter table patient
  owner to postgres;

create unique index patient_id_uindex
  on patient (id);

create table procedure
(
  id          serial    not null
    constraint study_pk
      primary key
    constraint study_patient_id_fk
      references patient,
  patient     integer   not null,
  description char(100) not null,
  status      integer   not null,
  starttime   date      not null,
  endtime     date
);

alter table procedure
  owner to postgres;

create unique index study_id_uindex
  on procedure (id);

create table room
(
  id   serial    not null
    constraint room_pk
      primary key,
  name char(100) not null
);

alter table room
  owner to postgres;

create unique index room_id_uindex
  on room (id);

create table doctor
(
  id   serial    not null
    constraint doctor_pk
      primary key,
  name char(100) not null
);

alter table doctor
  owner to postgres;

create unique index doctor_id_uindex
  on doctor (id);



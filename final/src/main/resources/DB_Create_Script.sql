create database postgres
  with owner postgres;

comment on database postgres is 'default administrative connection database';

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table patient
(
  id         serial not null
    constraint patient_pk
      primary key,
  name       varchar(100),
  sex        integer,
  dayofbirth date
);

alter table patient
  owner to postgres;

create unique index patient_id_uindex
  on patient (id);

create table room
(
  id   serial       not null
    constraint room_pk
      primary key,
  name varchar(100) not null
);

alter table room
  owner to postgres;

create unique index room_id_uindex
  on room (id);

create table doctor
(
  id   serial       not null
    constraint doctor_pk
      primary key,
  name varchar(100) not null
);

alter table doctor
  owner to postgres;

create table procedure
(
  id          serial       not null
    constraint procedure_pk
      primary key,
  patient     integer      not null
    constraint procedure_patient_id_fk
      references patient,
  description varchar(100) not null,
  status      integer      not null,
  doctor      integer      not null
    constraint procedure_doctor_id_fk
      references doctor,
  room        integer      not null
    constraint procedure_room_id_fk
      references room,
  starttime   time         not null,
  endtime     time,
  date        date         not null
);

alter table procedure
  owner to postgres;

create unique index procedure_id_uindex
  on procedure (id);

create unique index doctor_id_uindex
  on doctor (id);


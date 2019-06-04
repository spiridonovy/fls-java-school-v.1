CREATE TABLE public.doctor
(
    id serial NOT NULL,
    name varchar NOT NULL
);

CREATE TABLE public.patient
(
    id serial NOT NULL,
    surname varchar NOT NULL,
    name varchar NOT NULL,
    sex varchar,
    birthday date
);

CREATE TABLE public.room
(
    id serial NOT NULL,
    name varchar NOT NULL
);

CREATE TABLE public.study
(
    id serial NOT NULL,
    id_patient int NOT NULL,
    description varchar NOT NULL,
    status varchar DEFAULT 'PLANNED' NOT NULL,
    start_time date NOT NULL,
    end_time date,
    CONSTRAINT study_patient_id_fk FOREIGN KEY (id_patient) REFERENCES public.patient (id),
    CONSTRAINT study___fk FOREIGN KEY () REFERENCES
);
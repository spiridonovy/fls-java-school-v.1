CREATE TABLE doctors(
    id serial PRIMARY KEY,
    doctor_name varchar NOT NULL
);

CREATE TABLE rooms(
    id serial PRIMARY KEY,
    room_name varchar NOT NULL
);

CREATE TABLE patients(
    id serial PRIMARY KEY,
    patient_name varchar NOT NULL,
    sex varchar,
    day_of_birth date
);

CREATE TABLE studies(
    id serial PRIMARY KEY,
    patient_id bigint  REFERENCES patients(id),
    description varchar NOT NULL,
    status varchar NOT NULL,
    start_time date NOT NULL,
    end_time date
);

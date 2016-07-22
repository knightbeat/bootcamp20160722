CREATE Database `travellers_db`;

USE `travellers_db`;

SET SQL_MODE = 'ALLOW_INVALID_DATES';

CREATE TABLE journey_plans(
    record_id INT AUTO_INCREMENT,
    passport VARCHAR(16),
    plan_id VARCHAR(16),
    start_time VARCHAR(4),
    start_zipcode VARCHAR(10),
    end_zipcode VARCHAR(10),
    PRIMARY KEY (record_id)
);

CREATE TABLE travellers(
    record_id INT AUTO_INCREMENT,
    passport VARCHAR(16),
    first_name VARCHAR(16),
    last_name VARCHAR(16),
    date_of_birth VARCHAR(20),
    PRIMARY KEY (record_id)
);

DELETE FROM travellers;

INSERT INTO travellers(passport,first_name,last_name,date_of_birth)  VALUES('N02341334','Jessey','Pinkman','1979-04-05 13:10:03');
INSERT INTO travellers(passport,first_name,last_name,date_of_birth)  VALUES('N02341335','Walter','White','1952-08-01 18:19:23');
INSERT INTO travellers(passport,first_name,last_name,date_of_birth)  VALUES('N02341336','Gustavo','Fring','1962-02-04 09:39:00');

DELETE FROM journey_plans;

INSERT INTO journey_plans(passport,plan_id,start_time,start_zipcode,end_zipcode) VALUES('N02341334','JNPLN001','0931','KT89HA','SW96DE');
INSERT INTO journey_plans(passport,plan_id,start_time,start_zipcode,end_zipcode) VALUES('N02341334','JNPLN002','1345','SW96DE','NN146BW');
INSERT INTO journey_plans(passport,plan_id,start_time,start_zipcode,end_zipcode) VALUES('N02341334','JNPLN003','2020','NN146BW','KT89HA');
INSERT INTO journey_plans(passport,plan_id,start_time,start_zipcode,end_zipcode) VALUES('N02341335','JNPLN001','1933','KT89HA','SW96DE');
INSERT INTO journey_plans(passport,plan_id,start_time,start_zipcode,end_zipcode) VALUES('N02341335','JNPLN002','2145','SW96DE','NN146BW');
INSERT INTO journey_plans(passport,plan_id,start_time,start_zipcode,end_zipcode) VALUES('N02341335','JNPLN003','0320','NN146BW','KT89HA');

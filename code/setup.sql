CREATE DATABASE if not exists mission;
USE mission;

CREATE USER if not exists mission_user IDENTIFIED BY '4315';
GRANT ALL PRIVILEGES ON mission.* TO mission_user;

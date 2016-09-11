CREATE DATABASE calculator
  CHARACTER SET utf8;
CREATE USER 'clcuser'
  IDENTIFIED BY 'clcpass';
GRANT ALL PRIVILEGES ON calculator.* TO 'clcuser';
FLUSH PRIVILEGES;
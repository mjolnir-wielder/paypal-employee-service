DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS address;

CREATE TABLE address (
  id INT AUTO_INCREMENT PRIMARY KEY,
  line1 VARCHAR(250) NOT NULL,
  line2 VARCHAR(250),
  city VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  country VARCHAR(250) NOT NULL,
  zip_code VARCHAR(250) NOT NULL
);

INSERT INTO address (line1, city, state, country, zip_code) VALUES
  ('A-43', 'Delhi', 'Delhi', 'India', '110004')
;

INSERT INTO address (line1, line2, city, state, country, zip_code) VALUES
   ('A-57', 'Model Town', 'Delhi', 'Delhi', 'India', '110006')
;

CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  date_of_birth VARCHAR(250) NOT NULL,
  address_id INT,
  FOREIGN KEY(address_id) references address
);

INSERT INTO employee (first_name, last_na   me, date_of_birth, address_id) VALUES
  ('Ankit', 'Agarwal', '1992-10-02', 1),
  ('Aakash', 'Sethi', '1990-10-23', 2)
;
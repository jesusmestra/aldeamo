DROP TABLE IF EXISTS arrays;
CREATE TABLE arrays (
  id int(11) NOT NULL AUTO_INCREMENT,
  input_array varchar(20) NOT NULL
);

ALTER TABLE arrays
  ADD PRIMARY KEY (id);

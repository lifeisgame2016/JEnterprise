ALTER TABLE DEVELOPERS ADD COLUMN SALARY INT;

UPDATE DEVELOPERS T
SET SALARY = 3000 + (T.ID_DEVELOPER * 700);
ALTER TABLE PROJECTS ADD COLUMN COST INT;

UPDATE PROJECTS
SET COST = 1000000+(ID_PROJECT * 300000);
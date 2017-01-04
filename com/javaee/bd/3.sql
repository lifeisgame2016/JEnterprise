select  sum(d.salary)
from skills s inner join developers d
on(s.id_developer=d.id_developer)
where s.name = 'Java';
select avg(salary)
from developers d
where d.id_project in (
	select p.id_project
	from projects p
	order by p.cost asc
    limit 1);
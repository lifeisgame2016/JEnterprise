select p.name as name_project
	,sum(d.salary) as max_cost
from developers d inner join projects p
on(d.id_project=p.id_project)
group by p.name
order by max_cost desc
limit 1
;
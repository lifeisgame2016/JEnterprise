with
	tab_project as (
    select id_company, id_customer , cost
        ,min(cost) over (partition by id_company order by cost) as min_val
    from projects p )
select c.name as customer
	,m.name as company
from tab_project t
	  ,customers c
    ,companies m
where t.cost = min_val
  and c.id_customer = t.id_customer
  and m.id_company = t.id_company;

SELECT animal_type,
       count(1)
from animal_ins
group by 1
order by animal_type
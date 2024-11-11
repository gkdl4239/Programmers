SELECT ANIMAL_ID,
       NAME,
       case when SEX_UPON_INTAKE regexp 'Neutered|Spayed' then 'O'
       else 'X' end '중성화'
from animal_ins 
order by animal_id

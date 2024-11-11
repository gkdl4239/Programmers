SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       if(freezer_yn is null,'N',freezer_yn) as FREEZER_YN
from food_warehouse
where warehouse_name like ("%경기%")
order by warehouse_id
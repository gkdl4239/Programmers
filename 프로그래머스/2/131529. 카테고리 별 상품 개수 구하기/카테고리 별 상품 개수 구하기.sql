SELECT substr(product_code,1,2) as category,
       count(1) as products
from product
group by 1
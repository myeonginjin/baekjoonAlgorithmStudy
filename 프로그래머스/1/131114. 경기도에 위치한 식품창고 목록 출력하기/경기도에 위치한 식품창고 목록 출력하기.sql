-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, 
case 
when WAREHOUSE_ID in (
select WAREHOUSE_ID 
from FOOD_WAREHOUSE
where FREEZER_YN is null
) 
then 'N'
else FREEZER_YN
end as FREEZER_YN
from FOOD_WAREHOUSE
where ADDRESS like '%경기%'
order by WAREHOUSE_ID ASC



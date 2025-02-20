select distinct CAR_ID,
case 
when CAR_ID in (
    select CAR_ID 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where '2022-10-16' between START_DATE and END_DATE
    group by CAR_ID
) then '대여중'
else '대여 가능'
end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID DESC 
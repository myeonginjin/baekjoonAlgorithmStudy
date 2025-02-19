-- 코드를 입력하세요


SELECT 
    DISTINCT CAR_ID,        -- 메인 쿼리의 SELECT
    CASE 
        WHEN CAR_ID IN (
            SELECT CAR_ID   -- 서브쿼리의 SELECT
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY  -- 서브쿼리의 FROM
            WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE  -- 서브쿼리의 WHERE
        ) THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY  -- 메인 쿼리의 FROM
ORDER BY CAR_ID DESC;      -- 메인 쿼리의 ORDER BY
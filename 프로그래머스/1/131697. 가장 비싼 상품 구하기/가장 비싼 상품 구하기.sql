-- 코드를 입력하세요
SELECT PRICE as MAX_PRICE
from PRODUCT
where PRICE = (select MAX(PRICE) from PRODUCT) 
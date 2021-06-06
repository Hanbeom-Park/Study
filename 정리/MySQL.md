#### MySQL

---

* IFNULL(값, DEFAULT) : 값이 비어있으면 DEFAULT를 반환합니다
* ABS(숫자) : 절대값을 구합니다.
* CEIL(숫자) : 값보다 큰 정수 중 가장 작은 정수를 구합니다. 소수점 이하 올림을 의미합니다.
* FLOOR(숫자) : 값보다 작은 정수 중 가장 큰 정수를 구합니다. 소수점 이하 버림을 의미합니다.
* ROUND(숫자, 자릿수) : 자릿수를 기준으로 반올림합니다.
* TRUNCATE(숫자, 자릿수) : 자릿수를 기준으로 버림합니다. 
* POW(X, Y) , POWER(X, Y) : X의 Y승을 의미합니다.
* MOD(분자, 분모) : 분자를 분모로 나눈 나머지를 구합니다.
* GREATEST(숫자1, 숫자2, ...) : 주어진 숫자 중에 가장 큰 값을 반환합니다.
* LEAST(숫자1, 숫자2, ...) : 주어진 숫자 중에 가장 작은 값을 반환합니다.
* CAST : cast('1234' as signed integer), cast('2019-03-12' as date)
* MD5

---

##### STRING 

* LPAD("값",10,'*') : `*********값` 
* LPAD("값",10,'*') : `값*********`  
* SUBSTR("ABCDE",2,2) : "BC"
* instr ( 전체문자열, 비교문자열 ) :  '전체문자열'에서 '비교문자열'이 존재하는지 비교, 존재하면 위치값을 반환하는 함수

----

##### DATE

* now(), sysdate(), curdate() 
* date_format(now(), '%Y-%m-%d %H-%i-%s') from dual
* date_add(now(), interval -1 day)
* datediff(now(),'2000-03-10')
* GROUP_CONCAT : group_concat(distinct name order by name),  group_concat(name separator '|')



---

* CASE문

  ```mysql
  select employee_id, first_name,salary,
  case  when (salary>20000) then '수'
  	when (salary>10000) then '우'
      else '미'
  end as sal
  from employees;
  ```

* 

---

```
SELECT CUSTOMER_ID FROM PAYMENT WHERE ;
SELECT EMAIL FROM CUSTOMER WHERE EMAIL LIKE '_%@%_'
```

* WITH RECURSIVE 

  ~~~
  WITH RECURSIVE 테이블명 AS(
  SELECT 초기값 AS 컬럼별명1
  UNION ALL
  SELECT 컬럼별명1 계산식 FROM 테이블명 WHERE 제어문)
  ~~~

  

* set

  ```
   SET @변수이름 = 대입값;   혹은  SET @변수이름 := 대입값;
     SELECT @변수이름 := 대입값;
  ```

  
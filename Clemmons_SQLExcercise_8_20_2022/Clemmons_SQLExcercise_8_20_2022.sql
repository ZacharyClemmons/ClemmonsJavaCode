

CREATE TABLE Table8 ( ID int, Name varchar(255), Country varchar(255));

insert into Table8 values (1, 'Jack Johnson', 'United States');
  insert into Ev values (2, 11);
  insert into Ev values (3, 57);
  insert into Ev values (4, 24);
  insert into Ev values (5, 47);
  






select -1*value  from  "table1"; 


select id from "departments" where revenue > 0;


SELECT LEFT(Year, 2) AS ExtractString
FROM Century; 

select Value, case when Value % 2 = 0 then 'The answer is even' when Value % 2 = 1 then 'The answer is odd' end as even_odd from Ev; 


select age, count(*)  as people_count from Table5 group by age order by age asc;

select id, name, concat ('Hi,', name , '! How are you today?') as greeting from table5;

select * from table7 order by "sold" asc limit 5;

select name from table8 where country !='United States' and country !='Canada';

select distinct age from table5 group by age order by age asc;

select sum(age)from table5;
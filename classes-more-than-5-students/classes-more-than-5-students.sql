# Write your MySQL query statement below

Select Distinct class from courses where class in (Select class from courses group by class having Count(Distinct student)>=5)
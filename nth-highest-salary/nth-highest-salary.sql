CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select Salary as result from Employee e1 where N-1 = (select count(Distinct Salary) from Employee e2 where e2.Salary>e1.Salary) limit 1
  );
END
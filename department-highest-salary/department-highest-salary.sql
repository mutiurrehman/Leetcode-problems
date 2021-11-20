# Write your MySQL query statement below

select department.name as Department, employee.name as Employee, employee.salary from employee join department on employee.departmentId = department.Id where (employee.departmentId, salary) in (select departmentId, max(salary) from employee group by departmentId)

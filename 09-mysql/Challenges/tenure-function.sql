
   
   SELECT
    name,
    hire_date,
    GetTenureCategory(hire_date) AS tenure_category
FROM employees;

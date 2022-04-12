# Write your MySQL query statement below
select DISTINCT v1.author_id as id
from Views as v1 INNER JOIN Views as v2
ON v1.author_id = v2.viewer_id AND v1.viewer_id = v2.viewer_id
order by id
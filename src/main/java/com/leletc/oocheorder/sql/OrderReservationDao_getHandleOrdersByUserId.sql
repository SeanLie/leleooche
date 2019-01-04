SELECT *
from auto_orders_reservation o
WHERE o.id IN (
  SELECT h.order_id FROM auto_orders_handle h
    WHERE h.deal_user_id = :userId)
  <#if currentDate ?exists && currentDate ?length gt 0>
  AND DATE_FORMAT(order_time,'%Y-%m-%d') = :currentDate
  </#if>
ORDER BY
  order_level,
  order_status,
  order_time DESC
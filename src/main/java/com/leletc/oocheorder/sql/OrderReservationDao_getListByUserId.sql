SELECT * FROM auto_orders_reservation
WHERE
	order_users = :userId
<#if currentDate ?exists && currentDate ?length gt 0>
  AND DATE_FORMAT(order_time,'%Y-%m-%d') = :currentDate
</#if>
ORDER BY
	order_time DESC,
  order_status,
	order_level
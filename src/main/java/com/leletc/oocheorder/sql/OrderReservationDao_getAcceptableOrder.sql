SELECT * FROM auto_orders_reservation
WHERE
	order_status = :orderStatus
  AND DATE_FORMAT(order_time,'%Y-%m-%d') = :currentDate
  AND id = :orderId
ORDER BY
	order_level ASC,
	order_time ASC
LIMIT 1

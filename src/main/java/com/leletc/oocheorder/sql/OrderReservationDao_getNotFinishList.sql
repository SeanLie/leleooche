SELECT * FROM AUTO_ORDERS_RESERVATION
  WHERE order_users = :userId
AND plate_number = :plateNumber
AND (
<#list finishedStatusList as status>
  <#if (status_index > 0)>
     OR
  </#if>
  order_status != ${status}
</#list>
)
ORDER BY order_time DESC

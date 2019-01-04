SELECT * FROM auto_base_products p WHERE p.sys_org_code = (
	SELECT d.org_code from t_s_depart d WHERE d.id = (
		SELECT bu.departid from t_s_base_user bu WHERE bu.id = :userId
	)
)
AND p.id = :parentProductId
AND p.product_status = :productStatus

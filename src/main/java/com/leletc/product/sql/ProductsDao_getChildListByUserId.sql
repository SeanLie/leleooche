SELECT p.* FROM auto_base_products p WHERE p.id IN (
  SELECT product_id FROM auto_base_user_products up WHERE up.user_id = :userId
)
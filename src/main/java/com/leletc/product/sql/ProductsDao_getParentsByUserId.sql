SELECT p.* FROM auto_base_products p WHERE p.parent_product_id IN (
  SELECT product_id FROM auto_base_user_products up WHERE up.user_id = :userId
)
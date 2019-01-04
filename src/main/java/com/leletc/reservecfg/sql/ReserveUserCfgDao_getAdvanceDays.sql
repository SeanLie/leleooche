SELECT c.user_advance_days FROM auto_reserve_user_cfg c
WHERE c.user_person_level = (
  SELECT u.personlevel FROM t_s_user u WHERE id = :userId
  )
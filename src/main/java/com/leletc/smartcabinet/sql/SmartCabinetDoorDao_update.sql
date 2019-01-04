UPDATE auto_smart_cabinet_door
    SET is_open = :doorEntity.isOpen
    <#if doorEntity.isOccupancy ?exists>
    , is_occupancy = :doorEntity.isOccupancy
    </#if>
    <#if doorEntity.isOccupancy ?exists>
    , storage_status = :doorEntity.storageStatus
    </#if>
WHERE id = :doorEntity.id
 AND box_no = :doorEntity.boxNo
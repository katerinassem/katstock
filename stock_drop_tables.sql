
DROP TABLE katstock.stock_item ,
 katstock.place ,
 katstock.place_type ,
  katstock.waybill ,
   katstock.organization ,
    katstock.position ,
     katstock.state ,
      katstock.goods ,
       katstock.measure ,
        katstock.user,
         katstock.stock_organization ,
          katstock.role ,
           katstock.stock ,
            katstock.address 
CASCADE;

DROP SEQUENCE katstock.stock_item_seq ;
DROP SEQUENCE katstock.waybill_seq ;
DROP SEQUENCE katstock.organization_seq ;
DROP SEQUENCE katstock.stock_organization_seq ;
DROP SEQUENCE katstock.position_seq ;
DROP SEQUENCE katstock.state_seq ;
DROP SEQUENCE katstock.goods_seq ;
DROP SEQUENCE katstock.measure_seq ;
DROP SEQUENCE katstock.user_seq ;
DROP SEQUENCE katstock.role_seq ;
DROP SEQUENCE katstock.stock_seq ;
DROP SEQUENCE katstock.address_seq ;
DROP SEQUENCE katstock.place_seq ;
DROP SEQUENCE katstock.place_type_seq ;

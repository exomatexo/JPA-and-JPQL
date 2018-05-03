CREATE TABLE APP.CUSTOMER (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE APP.PRODUCT (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, NAME VARCHAR(255), PRICE FLOAT, PRIMARY KEY (ID))
CREATE TABLE APP.PURCHASE (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, ADDRESS VARCHAR(255), DATE_OF_TRANSACTION DATE, CUSTOMER_ID BIGINT, DELIVERY_COMPANY_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE APP.PURCHASE_ITEM (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, QUANTITY INTEGER, PRODUCT_ID BIGINT, PURCHASE_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE APP.Delivery_company (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, ADDRESS VARCHAR(255), NAME VARCHAR(255), PHONE_NUMBER INTEGER, MAIL VARCHAR(255), PRIMARY KEY (ID))
ALTER TABLE APP.PURCHASE ADD CONSTRAINT PURCHASECUSTOMERID FOREIGN KEY (CUSTOMER_ID) REFERENCES APP.CUSTOMER (ID)
ALTER TABLE APP.PURCHASE ADD CONSTRAINT PRCHSDLVRYCMPANYID FOREIGN KEY (DELIVERY_COMPANY_ID) REFERENCES APP.Delivery_company (ID)
ALTER TABLE APP.PURCHASE_ITEM ADD CONSTRAINT PRCHASEITEMPRDCTID FOREIGN KEY (PRODUCT_ID) REFERENCES APP.PRODUCT (ID)
ALTER TABLE APP.PURCHASE_ITEM ADD CONSTRAINT PRCHSEITEMPRCHSEID FOREIGN KEY (PURCHASE_ID) REFERENCES APP.PURCHASE (ID)
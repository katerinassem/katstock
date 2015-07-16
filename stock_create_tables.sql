
CREATE TABLE katstock.address (
	address_id BIGINT PRIMARY KEY,
	country VARCHAR(15) NOT NULL,
	region VARCHAR(50) NOT NULL,
	street VARCHAR(20),
	building VARCHAR(10),
	description VARCHAR(200)
);

CREATE TABLE katstock.stock_organization (
	stock_organization_id BIGINT PRIMARY KEY,
	title VARCHAR(30) NOT NULL,
	address_id BIGINT NOT NULL 
		REFERENCES katstock.address
		ON DELETE RESTRICT
);

CREATE TABLE katstock.organization (
	organization_id BIGINT PRIMARY KEY,
	title VARCHAR(30) NOT NULL,
	address_id BIGINT NOT NULL 
		REFERENCES katstock.address
		ON DELETE RESTRICT,
	stock_organization_id BIGINT NOT NULL 
		REFERENCES katstock.stock_organization
		ON DELETE CASCADE
);

CREATE TABLE katstock.stock (
	stock_id BIGINT PRIMARY KEY,
	stock_name VARCHAR(20) NOT NULL,
	description VARCHAR(200),
	square INTEGER,
	cost_per_kg_per_day DECIMAL NOT NULL,
	photo_url VARCHAR(500),
/*	total_capacity INTEGER NOT NULL,
	free_capacity INTEGER NOT NULL,
*/
	address_id BIGINT NOT NULL 
		REFERENCES katstock.address
		ON DELETE RESTRICT,
	stock_organization_id BIGINT NOT NULL 
		REFERENCES katstock.stock_organization
		ON DELETE CASCADE	 
);

CREATE TABLE katstock.role (
	role_id BIGINT PRIMARY KEY,
	role_name VARCHAR(20) NOT NULL
);

CREATE TABLE katstock.user (
	user_id BIGINT PRIMARY KEY,
	enabled BOOLEAN NOT NULL,
	user_name VARCHAR(20) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	email VARCHAR(40) NOT NULL,
	user_password VARCHAR(50) NOT NULL,
	role_id BIGINT NOT NULL
		REFERENCES katstock.role
		ON DELETE RESTRICT,
	stock_organization_id BIGINT NOT NULL 
		REFERENCES katstock.stock_organization
		ON DELETE CASCADE	
);

CREATE TABLE katstock.position (
	position_id BIGINT PRIMARY KEY,
	position_name VARCHAR(20) NOT NULL
);

CREATE TABLE katstock.waybill (
	waybill_id BIGINT PRIMARY KEY,
	total_cost DECIMAL NOT NULL,
	total_weight INTEGER NOT NULL,
	receipt_date DATE NOT NULL,
	export_date DATE NOT NULL,
	tax_cost DECIMAL NOT NULL,
	stock_id BIGINT NOT NULL
		REFERENCES katstock.stock
		ON DELETE CASCADE,
	sender_organization_id BIGINT
		REFERENCES katstock.organization
		ON DELETE RESTRICT,
	receipent_organization_id BIGINT
		REFERENCES katstock.organization
		ON DELETE RESTRICT,
		
	transmitter_fio VARCHAR(20) NOT NULL,
	transmitter_position_id BIGINT NOT NULL
		REFERENCES katstock.position
		ON DELETE RESTRICT,		
		
	acceptor_fio VARCHAR(20) NOT NULL,
	acceptor_position_id BIGINT NOT NULL
		REFERENCES katstock.position
		ON DELETE RESTRICT,
			
	manager_id BIGINT NOT NULL 
		REFERENCES katstock.user
		ON DELETE CASCADE
);

CREATE TABLE katstock.measure (	
	measure_id BIGINT PRIMARY KEY,
	measure_name VARCHAR(20) NOT NULL
);

CREATE TABLE katstock.goods (
	goods_id BIGINT PRIMARY KEY,
	unique_number BIGINT NOT NULL,
	cost DECIMAL NOT NULL,
	description VARCHAR(100) NOT NULL,
	storage_conditions VARCHAR(100),
	measure_id BIGINT NOT NULL
		REFERENCES katstock.measure
		ON DELETE RESTRICT	
);

CREATE TABLE katstock.goods_item (
	goods_item_id BIGINT PRIMARY KEY, 
	weight INTEGER NOT NULL,
	goods_id BIGINT NOT NULL
		REFERENCES katstock.goods
		ON DELETE RESTRICT	
);

CREATE TABLE katstock.state (
	state_id BIGINT PRIMARY KEY,
	state_name VARCHAR(20) NOT NULL
);

CREATE TABLE katstock.stock_item (
	stock_item_id BIGINT PRIMARY KEY,
	quantity INTEGER NOT NULL,
	total_cost DECIMAL NOT NULL,
	goods_id BIGINT NOT NULL
		REFERENCES katstock.goods
		ON DELETE RESTRICT,
	waybill_id BIGINT NOT NULL
		REFERENCES katstock.waybill
		ON DELETE CASCADE,
	state_id BIGINT NOT NULL
		REFERENCES katstock.state
		ON DELETE RESTRICT		
);

CREATE TYPE katstock.PLACE_TYPE_NAME AS ENUM ('outside', 'inside', 'refrigerator', 'tank');

CREATE TABLE katstock.place (
	place_id BIGINT PRIMARY KEY,
	place_number INTEGER NOT NULL,
	available BOOLEAN NOT NULL,
	place_type katstock.PLACE_TYPE_NAME NOT NULL,
	stock_id BIGINT NOT NULL
		REFERENCES katstock.stock
		ON DELETE CASCADE,
	stock_item_id BIGINT
		REFERENCES katstock.stock_item
		ON DELETE SET NULL
);

CREATE SEQUENCE katstock.stock_item_seq ;
CREATE SEQUENCE katstock.waybill_seq ;
CREATE SEQUENCE katstock.organization_seq ;
CREATE SEQUENCE katstock.stock_organization_seq ;
CREATE SEQUENCE katstock.place_seq ;
CREATE SEQUENCE katstock.position_seq ;
CREATE SEQUENCE katstock.state_seq ;
CREATE SEQUENCE katstock.goods_seq ;
CREATE SEQUENCE katstock.goods_item_seq;
CREATE SEQUENCE katstock.measure_seq ;
CREATE SEQUENCE katstock.user_seq ;
CREATE SEQUENCE katstock.role_seq ;
CREATE SEQUENCE katstock.stock_seq ;
CREATE SEQUENCE katstock.address_seq ;








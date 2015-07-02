
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
	cost_per_kg_per_day MONEY NOT NULL,
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
	user_name VARCHAR(20) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	email VARCHAR(40),
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
	total_cost MONEY NOT NULL,
	total_weight INTEGER NOT NULL,
	receipt_date DATE NOT NULL,
	export_date DATE NOT NULL,
	tax_cost MONEY NOT NULL,
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
	cost MONEY NOT NULL,
	weight INTEGER NOT NULL,
	description VARCHAR(100) NOT NULL,
	storage_conditions VARCHAR(100),
	measure_id BIGINT NOT NULL
		REFERENCES katstock.measure
		ON DELETE RESTRICT	
);

CREATE TABLE katstock.state (
	state_id BIGINT PRIMARY KEY,
	state_name VARCHAR(20) NOT NULL
);

CREATE TABLE katstock.place_type (
	place_type_id BIGINT PRIMARY KEY,
	place_name VARCHAR(50) NOT NULL
);

CREATE TABLE katstock.stock_item (
	stock_item_id BIGINT PRIMARY KEY,
	quantity INTEGER NOT NULL,
	total_cost MONEY NOT NULL,
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

CREATE TABLE katstock.place (
	place_id BIGINT PRIMARY KEY,
	place_number INTEGER NOT NULL,
	available BOOLEAN NOT NULL,
	place_type_id BIGINT NOT NULL
		REFERENCES katstock.place_type
		ON DELETE RESTRICT,
	stock_id BIGINT NOT NULL
		REFERENCES katstock.stock
		ON DELETE CASCADE
	stock_item_id BIGINT
		REFERENCES katstock.stock_item
		ON DELETE SET NULL
);

CREATE SEQUENCE stock_item_seq ;
CREATE SEQUENCE waybill_seq ;
CREATE SEQUENCE organization_seq ;
CREATE SEQUENCE stock_organization_seq ;
CREATE SEQUENCE place_type_seq ;
CREATE SEQUENCE place_seq ;
CREATE SEQUENCE position_seq ;
CREATE SEQUENCE state_seq ;
CREATE SEQUENCE goods_seq ;
CREATE SEQUENCE measure_seq ;
CREATE SEQUENCE user_seq ;
CREATE SEQUENCE role_seq ;
CREATE SEQUENCE stock_seq ;
CREATE SEQUENCE address_seq ;








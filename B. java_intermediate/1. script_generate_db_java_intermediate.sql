-- DROP DATABASE java_intermediate;

CREATE DATABASE java_intermediate
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;


-- DROP TABLE m_customers;

CREATE TABLE m_customers
(
  customer_id bigint NOT NULL,
  company_name character varying(50),
  first_name character varying(30),
  last_name character varying(50),
  billing_address character varying(255),
  city character varying(50),
  state_or_province character varying(20),
  zip_code character varying(20),
  email character varying(75),
  company_website character varying(200),
  phone_number character varying(30),
  fax_number character varying(30),
  ship_address character varying(255),
  ship_city character varying(50),
  ship_state_or_province character varying(50),
  ship_zip_code character varying(20),
  ship_phone_number character varying(30),
  CONSTRAINT m_customers_pkey PRIMARY KEY (customer_id)
);


-- DROP TABLE m_employees;

CREATE TABLE m_employees
(
  employee_id bigint NOT NULL,
  first_name character varying(50),
  last_name character varying(50),
  title character varying(50),
  work_phone character varying(30),
  CONSTRAINT m_employees_pkey PRIMARY KEY (employee_id)
);


-- DROP TABLE m_products;

CREATE TABLE m_products
(
  product_id bigint NOT NULL,
  product_name character varying(50),
  unit_price numeric(30,2),
  in_stock character varying(1),
  CONSTRAINT m_products_pkey PRIMARY KEY (product_id)
);


-- DROP TABLE m_shipping_methods;

CREATE TABLE m_shipping_methods
(
  shipping_method_id bigint NOT NULL,
  shipping_method character varying(20),
  CONSTRAINT m_shipping_methods_pkey PRIMARY KEY (shipping_method_id)
);


-- DROP TABLE t_orders;

CREATE TABLE t_orders
(
  order_id bigint NOT NULL,
  m_customer_id bigint,
  m_employee_id bigint,
  order_date timestamp without time zone,
  purchase_order_number character varying(30),
  ship_date timestamp without time zone,
  m_shipping_method_id bigint,
  freight_charge numeric(30,2),
  taxes numeric(30,2),
  payment_received character varying(1),
  comment character varying(150),
  CONSTRAINT t_orders_pkey PRIMARY KEY (order_id)
);


-- DROP TABLE t_order_details;

CREATE TABLE t_order_details
(
  order_detail_id bigint NOT NULL,
  m_order_id bigint,
  m_product_id bigint,
  quantity bigint,
  unit_price numeric(30,2),
  discount numeric(30,2),
  CONSTRAINT t_order_details_pkey PRIMARY KEY (order_detail_id)
);
--TABLE ACCOUNT
CREATE TABLE public.account (
	account_id int4 NOT NULL,
	account_no varchar NOT NULL,
	account_balance varchar NOT NULL,
	CONSTRAINT account_pk PRIMARY KEY (account_id)
);

========================================================================================================
--TABLE ADDRESS
CREATE TABLE public.address (
	aid int4 NOT NULL,
	city varchar NOT NULL,
	state varchar NOT NULL,
	country varchar NOT NULL,
	pincode varchar NOT NULL,
	CONSTRAINT address_pk PRIMARY KEY (aid)
);


========================================================================================================
--TABLE FURNITURE
CREATE TABLE public.furniture (
	furniture_id int4 NOT NULL,
	furniture_name varchar NOT NULL,
	furniture_color varchar NOT NULL,
	furniture_model varchar NOT NULL,
	price float8 NOT NULL,
	CONSTRAINT furniture_pk PRIMARY KEY (furniture_id)
);

========================================================================================================
--TABLE REVIEW
CREATE TABLE public.review (
	review_id int4 NOT NULL,
	description varchar NULL,
	review_rating int4 NULL,
	CONSTRAINT review_pk PRIMARY KEY (review_id)
);

========================================================================================================
--TABLE BILL
CREATE TABLE public.customer_order (
	order_id varchar NOT NULL,
	order_date date NULL,
	furniture int4 NOT NULL,
	customer int4 NOT NULL,
	quanity int4 NOT NULL,
	price float8 NOT NULL,
	amount float8 NOT NULL,
	status varchar NOT NULL,
	CONSTRAINT orderid_pk PRIMARY KEY (order_id),
	CONSTRAINT orderid_fk FOREIGN KEY (furniture) REFERENCES public.furniture(furniture_id),
	CONSTRAINT orderid_fk_1 FOREIGN KEY (customer) REFERENCES public.customer(uid)
);
========================================================================================================
--TABLE CUSTOMER
CREATE TABLE public.customer (
	address int4 NOT NULL,
	account int4 NOT NULL,
	mobile_no varchar NOT NULL,
	email varchar NULL,
	review int4 NOT NULL,
	uid int4 NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	"role" varchar NOT NULL,
	discriminator varchar NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (uid),
	CONSTRAINT customer_fk FOREIGN KEY (review) REFERENCES public.review(review_id),
	CONSTRAINT customer_fk_1 FOREIGN KEY (account) REFERENCES public.account(account_id),
	CONSTRAINT customer_fk_2 FOREIGN KEY (address) REFERENCES public.address(aid)
);

========================================================================================================
--TABLE CART
CREATE TABLE public.cart (
	cart_id int4 NOT NULL,
	order_num int4 NOT NULL,
	customer int4 NOT NULL,
	furniture int4 NOT NULL,
	quantity int4 NOT NULL,
	CONSTRAINT cart_pk PRIMARY KEY (cart_id),
	CONSTRAINT cart_fk FOREIGN KEY (furniture) REFERENCES public.furniture(furniture_id),
	CONSTRAINT cart_fk_1 FOREIGN KEY (customer) REFERENCES public.customer(uid)
);

========================================================================================================
--TABLE CUSTOMER_ORDER

CREATE TABLE public.customer_order (
	order_id int4 NOT NULL,
	order_date date NULL,
	furniture int4 NOT NULL,
	customer int4 NOT NULL,
	quanity int4 NOT NULL,
	price float8 NOT NULL,
	amount float8 NOT NULL,
	status varchar NOT NULL,
	CONSTRAINT orderid_pk PRIMARY KEY (order_id),
	CONSTRAINT orderid_fk FOREIGN KEY (furniture) REFERENCES public.furniture(furniture_id),
	CONSTRAINT orderid_fk_1 FOREIGN KEY (customer) REFERENCES public.customer(uid)
);


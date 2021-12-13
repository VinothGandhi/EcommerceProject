
--user


create table users1(user_id int primary key,Name varchar2(100)not null,password varchar2(100)not null,First_name varchar2(100)not null,
Last_name varchar2(100)not null,mobile_no int not null,email_id varchar2(50)not null);
drop table users1;
desc users1;
---------------------------------------------------------------------------------------------------------------------------------------------------

--useraddress

create table useraddress (User_Address_id int primary key,Address_line1 varchar2(100) not null,
Address_line2 varchar2(100) not null,City varchar2(100)not null,Postal_code int not null,Country varchar2(100)not null,
Email varchar2(50) not null,Mobile_no int not null,User_id int,foreign key(User_id)references users1(User_id)) ;
 desc useraddress;
 drop table useraddress;
 ------------------------------------------------------------------------------------------------------------------------------------
 
 --UserPayment
 
 /*create table Userpayment(Payment_id int primary key,Payment_type varchar2(100) not null,Account_no int not null,Expiry date not null,
 User_id int,foreign key(User_id)references users1(User_id));
  drop table Userpayment;
  desc Userpayment;*/
 
 -----------------------------------------------------------------------------------------------------------------------------------
 
 --Products
 
 create table products1 (products_id int primary key,product_name varchar2(100),
Brand_type varchar2(100),product_size int,color varchar2(50),prices int,Productinventory_id int,
foreign key(Productinventory_id) references  Productinventory(Productinventory_id));

drop table products1;
-----------------------------------------------------------------------------------------------------------------------------------------

--ProductInventory
 
 create table Productinventory(Productinventory_id int primary key,Quantity int not null);
 
 ----------------------------------------------------------------------------------------------------------------------------------------
 
 --Ordersdetails
 
 create table Orderss1(Order_id int primary key,Total int not null,User_id int,Payment_id int ,foreign key(User_id)
 references users1(user_id),foreign key(Payment_id) references Paymentdetails(Payment_id));
 
 ----------------------------------------------------------------------------------------------------------------------------------------
 
 --Orderitems
 
 create table Orderitems1(Item_id int primary key,Quantity int not null);,Order_id int,products_id int,foreign key(Order_id)
 references Orders1(Order_id),foreign key(products_id) references products1(products_id));
 
 -----------------------------------------------------------------------------------------------------------------------------------------
 
 --cartitems
 
 create table Cartitems1(Cartitems_id int primary key,Quantity int not null);,products_id,
 foreign key(products_id) references products1(products_id));
 
 -------------------------------------------------------------------------------------------------------------------------------------------
 
 --PaymentDetails
 
 create table Invoicebill(Invoicebill_id int primary key,Amount int not null,Status varchar2(50) not null,Order_id int,
 User_id int, foreign key(Order_id) references Orders1(Order_id),
 foreign key(User_id)references users1(User_id));
  drop table Invoicebill;
  desc Invoicebill;
 -------------------------------------------------------------------------------------------------------------------------------------------
 alter table users1 add Wallet int not null;
 alter table users1 modify Wallet int not null;
 
 --------------------------------------------------------------------------------------------------------------------------------------------
 
 
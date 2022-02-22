create table userinfo
(
employeeid number(6) primary key,
employeename varchar2(30) not null,
email varchar2(30) unique not null,
emppassword varchar2(30) ,
role_type varchar2(30),
deptname varchar2(30)
)
================================
create table skills
(
skillid identity,
employeeid number(6) unique,
skilltype varchar2(30),
skilldesc varchar2(100) ,
certifications varchar2(100),
teachinghrs number(5),
studentstrained number(5),
feedbackrating number(2),
constraint empfk foreign key(employeeid)  references userinfo(employeeid)
)

======================================

create table userprofile
(
profileid identity,
employeeid number(5) references userinfo(employeeid),
city varchar2(30),
region varchar2(20),
qualification varchar2(30),
supervisorname varchar2(30),
profileviews number(2),
profileselected number(2),
profilephoto VARCHAR2(30)
)
===============================
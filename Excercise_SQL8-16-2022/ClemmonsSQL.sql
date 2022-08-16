SELECT * FROM "Employee";

select * from "Employee" where "LastName"  like 'King';
select * from "Employee" where "FirstName"  like 'Andrew' and "ReportsTo"IS NULL;
select * from "Album"  order by "Title" desc;
select * from "Customer" order by "City"  asc;
select * from "Invoice" where "BillingAddress" like 'T%';
select * from "Invoice" where "Total" between '15' and '50';
select * from "Employee" where "HireDate"  >= '2003-01-06' and "HireDate"  <= '2004-01-03';
INSERT INTO "Genre" ("GenreId", "Name") VALUES (555,'DanceMusic');
INSERT INTO "Genre" ("GenreId", "Name") VALUES (556,'PartyMusic');
INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") VALUES (495, N'Adams', N'Andrew', N'General Manager', '1962/2/18', '2002/8/14', N'11120 Jasper Ave NW', N'Edmonton', N'AB', N'Canada', N'T5K 2N1', N'+1 (780) 428-9482', N'+1 (780) 428-3457', N'andrew@chinookcorp.com');
INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") VALUES (496, N'Edwards', N'Nancy', N'Sales Manager', 1, '1958/12/8', '2002/5/1', N'825 8 Ave SW', N'Calgary', N'AB', N'Canada', N'T2P 2T3', N'+1 (403) 262-3443', N'+1 (403) 262-3322', N'nancy@chinookcorp.com');
INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "Country", "PostalCode", "Phone", "Email", "SupportRepId") VALUES (500, N'Leonie', N'Kohler', N'Theodor-Heuss-Stra�e 34', N'Stuttgart', N'Germany', N'70174', N'+49 0711 2842222', N'leonekohler@surfeu.de', 5);
INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "Country", "PostalCode", "Phone", "Email", "SupportRepId") VALUES (501, N'Leonie', N'Kulhler', N'Theodor-Heuss-Strad�e 34', N'Stuttgart', N'Germoney', N'701474', N'+49 0711 28342222', N'leonekohler@surfeu.de', 5);
update "Customer"  set "FirstName"  = 'Robert', "LastName" = 'Walter'  where "FirstName"  = 'Robert';
update "Artist"  set "Name"  = 'Creedence Clearwater Revival'  where "Name"  = 'CCR';

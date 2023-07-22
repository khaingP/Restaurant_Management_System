INSERT INTO EATERY (ANIMAL_ALLOWED, ID, PHONE_NUMBER, APARTMENT, BUILDING, CITY, NAME, STREET,  WEBSITE, ZIP_CODE)
VALUES (true, 222 , '123456789', 'Apt 101', 'Building A', 'City A', 'ART SUSHI', 'Street 1', 'www.eatery1.com', '12345');

INSERT INTO EATERY_TYPES (EATERY_ID, TYPES)
VALUES (222, 'CAFE');

INSERT INTO MENU (EATERY_ID,ID,NAME)
VALUES (222,12,'SUSHI'), (222,13,'DRINK'), (222,14,'DESSERT'), (222,15,'MAINDISH');

INSERT INTO MENU_ITEM(MENU_ID,ID,NAME,PRICE,DESCRIPTION)
VALUES (12,21,'futomaki', 32,'With avocado and grilledsalmon'),
       (12,22,'Califonia Roll',51,'With avocado and salmon'),
       (12,25,'Hawaiian Roll',51,'With avocado,cheese and shrimp'),
       (13,26,'Matcha',32,'with ice'),
       (13,27,'Green  tea',51,'With avocado and salmon'),
       (14,28,'iceCream',15,'matcha flavor'),
       (15,30,'Ramen',32,'spicy'),
       (15,31,'luncx box',15,'japanese style'),
       (14,29,'Mochi',20,'Beans inside');


INSERT INTO PERSON (ID,PHONE_NUMBER,NAME ,SURNAME)
VALUES (100,'123456778','LISA','KIM');
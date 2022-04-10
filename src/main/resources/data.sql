INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Vernithane', 'Parket', 'Natural', '0.25L - 0.5L - 1L - 2.5L', 48.45);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Elastoprim Next', 'Hout - Harde kunststoffen', 'Wit', '0.5L - 1L - 2.5L', 46.06);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Elastoprim Hydro', 'Hout', 'Wit', '0.5L - 1L - 2.5L', 40.04);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'WoodAir Classic', 'Hout', 'Natural - Noten - Ebben - Palissand - Meranti - Lichte Eik', '0.5L - 1L - 2.5L',
        39.95);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'WoodAir Primer', 'Hout', 'Natural', '0.5L - 1L', 34.19);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Finifer', 'Ijzer - Staal', 'Wit - Zwart', '0.25L - 0.5L - 1L - 2.5L', 35.62);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'WoodOil Classic', 'Hout', 'Alle opties zijn mogelijk', '0.5L - 1L - 2L - 5L', 21.47);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Fixol', 'Verpoederde Ondergronden', 'Natural', '1L- 5L - 20L', 17.69);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Elastosatin XS', 'Hout', 'Wit', '0.5L - 1L - 2.5L', 53.43);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Premium Satin XS', 'Hout - Metaal - Kunststoffen', 'Wit - RAL: 9010', '0.5L - 1L - 2.5L', 47.89);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Satineau', 'Hout', 'Wit', '0.5L - 1L - 2.5L', 45.87);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Omniprim Extreme', 'Gladde Ondergronden', 'Wit - Zwart', '0.25L - 0.5L - 1L - 2.5L - 4L - 10L', 50.35);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Bolatex', 'Muren', 'Wit - RAL: 9010', '0.5L - 1L - 2.5L - 4L - 10L', 30.32);

INSERT INTO verfpot (id, naam, ondergrond, kleur_aanbod, verpakking_mogelijkheden, prijs)
VALUES (nextval('verf_seq'), 'Protect Satin', 'Parket', 'Natural', '0.25L - 0.75L - 1L - 2.5L', 31.94);

INSERT INTO USER (ID, username, password, role)
VALUES (nextval('USER_SEQ'), 'admin', '$2a$10$183YgFb7h2Meicizr0S6bO.v5wUky9lELv5b8UdCBdY7FueSDGTKm', 'ROLE_ADMIN');

INSERT INTO USER (ID, username, password, role)
VALUES (nextval('USER_SEQ'), 'daria', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');

INSERT INTO USER
(ID, username, password, role)
VALUES
(nextval('USER_SEQ'), 'giraf', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');
INSERT INTO KLANT
(ID, naam, adres, mail , user_id)
VALUES
(nextval('KLANT_SEQ'), 'Gillende Giraf', 'Antwerpen', 'giraf@hotmail.com', 3);

INSERT INTO USER
(ID, username, password, role)
VALUES
(nextval('USER_SEQ'), 'olifant', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');
INSERT INTO KLANT
(ID, naam, adres, mail , user_id)
VALUES
(nextval('KLANT_SEQ'), 'Olijke Olifant', 'Mechelen', 'olifant@hotmail.com', 4);

INSERT INTO USER
(ID, username, password, role)
VALUES
(nextval('USER_SEQ'), 'dromedaris', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');
INSERT INTO KLANT
(ID, naam, adres, mail , user_id)
VALUES
(nextval('KLANT_SEQ'), 'Dorstige Dromedaris', 'Mortsel','dromedaris@hotmail.com', 5);

INSERT INTO USER
(ID, username, password, role)
VALUES
(nextval('USER_SEQ'), 'draak', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');
INSERT INTO KLANT
(ID, naam, adres, mail , user_id)
VALUES
(nextval('KLANT_SEQ'), 'Dansende Draak', 'Lier','draak@hotmail.com', 6);

INSERT INTO USER
(ID, username, password, role)
VALUES
(nextval('USER_SEQ'), 'das', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');
INSERT INTO KLANT
(ID, naam, adres, mail , user_id)
VALUES
(nextval('KLANT_SEQ'), 'Drinkende Das', 'Antwerpen','das@hotmail.com', 7);

INSERT INTO USER
(ID, username, password, role)
VALUES
(nextval('USER_SEQ'), 'kikker', '$2a$10$qkYEzClRvGL03mzmKI1Tw.WGRKzm19S5aqQUeFb7x5/pGw/bhq96K', 'ROLE_USER');
INSERT INTO KLANT
(ID, naam, adres, mail , user_id)
VALUES
(nextval('KLANT_SEQ'), 'Klokkende Kikker', 'Berchem', 'kikker@hotmail.com',8);
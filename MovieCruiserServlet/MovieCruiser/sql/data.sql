-- -----------------------------------------------------
-- View MovieList Admin
-- -----------------------------------------------------

SELECT * FROM moviecruiser.movie_list;

INSERT INTO `moviecruiser`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('1', 'Avatar', '2787965087', 'Yes', '2017-03-15', 'Science Ficiton', 'Yes');
INSERT INTO `moviecruiser`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', 'Yes', '2017-12-23', 'Superhero', 'No');
INSERT INTO `moviecruiser`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('3', 'Titanic', '2187463944', 'Yes', '2017-08-21', 'Romance', 'No');
INSERT INTO `moviecruiser`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', 'No', '2017-07-02', 'Science Fiction', 'Yes');
INSERT INTO `moviecruiser`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_has_teaser`) VALUES ('5', 'Avengers: End Game', '2750760348', 'Yes', '2022-11-02', 'Superhero', 'Yes');

-- -----------------------------------------------------
-- User Table
-- -----------------------------------------------------

SELECT * FROM moviecruiser.user;

INSERT INTO `moviecruiser`.`user` (us_id, us_name) values (1, 'Vijay');
INSERT INTO `moviecruiser`.`user` (us_name) values ('Ajith');

-- -----------------------------------------------------
-- View Movie List Customer
-- -----------------------------------------------------

SELECT * FROM moviecruiser.movie_list 
WHERE mov_date_of_launch > CURDATE() AND mov_active = 'Yes';

-- -----------------------------------------------------
-- Edit Movie List
-- -----------------------------------------------------

SELECT * FROM `moviecruiser`.`movie_list` 	WHERE mov_id = 1;

UPDATE `moviecruiser`.`movie_list`
SET
mov_title='Spiderman',mov_gross='2080905030', mov_active= 'No', mov_date_of_launch= '2022-07-24', mov_genre= 'Superhero', mov_has_teaser= 'Yes'
where mov_id= 3;

-- -----------------------------------------------------
-- Add favorites
-- -----------------------------------------------------

SELECT * FROM moviecruiser.favorites;

INSERT INTO moviecruiser.favorites (fav_id, fav_us_id, fav_mov_id) values (1,1,1);
INSERT INTO moviecruiser.favorites (fav_us_id, fav_mov_id) values (1,2);
INSERT INTO moviecruiser.favorites (fav_us_id, fav_mov_id) values (1,3);
INSERT INTO moviecruiser.favorites (fav_us_id, fav_mov_id) values (2,3);
INSERT INTO moviecruiser.favorites (fav_us_id, fav_mov_id) values (2,4);
INSERT INTO moviecruiser.favorites (fav_us_id, fav_mov_id) values (2,5);

-- -----------------------------------------------------
-- View favorites
-- -----------------------------------------------------

USE moviecruiser;

SELECT * FROM moviecruiser.favorites;

SELECT movie_list.mov_title, movie_list.mov_has_teaser, movie_list.mov_gross FROM favorites
INNER JOIN movie_list on movie_list.mov_id = favorites.fav_mov_id
INNER JOIN user on user.us_id = favorites.fav_us_id
WHERE user.us_id=2;

SELECT movie_list.mov_title, movie_list.mov_genre, movie_list.mov_date_of_launch, movie_list.mov_has_teaser, movie_list.mov_gross FROM favorites
INNER JOIN movie_list on movie_list.mov_id = favorites.fav_mov_id
WHERE favorites.fav_us_id=2;

SELECT user.us_id, sum(movie_list.mov_gross) as mov_gross_total FROM favorites
INNER JOIN movie_list on movie_list.mov_id = favorites.fav_mov_id
INNER JOIN user on user.us_id = favorites.fav_us_id
WHERE user.us_id=2;

SELECT user.us_id, count(favorites.fav_id) as mov_no_of_fav FROM favorites
INNER JOIN movie_list on movie_list.mov_id = favorites.fav_mov_id
INNER JOIN user on user.us_id = favorites.fav_us_id
WHERE user.us_id=2;
-- -----------------------------------------------------
-- Remove Item From favorites
-- -----------------------------------------------------

USE moviecruiser;

DELETE favorites FROM favorites
WHERE fav_us_id=2 AND fav_mov_id = 3;

SELECT movie_list.mov_title, movie_list.mov_has_teaser, movie_list.mov_gross FROM favorites
INNER JOIN movie_list on movie_list.mov_id = favorites.fav_mov_id
WHERE favorites.fav_us_id=2;                                                            

-- ------------------------------------------------------
-- ------------------------------------------------------
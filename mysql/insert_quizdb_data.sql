-- -----------------------------------------------------
-- РЕФАКТОРИНГ БД
-- -----------------------------------------------------
DROP TABLE RESULT;

CREATE TABLE `Result` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`Fk_UserId_result` INT NOT NULL,
	`TestBall` INT NOT NULL,
	`TaskBall` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Result` ADD CONSTRAINT `Result_fk0` FOREIGN KEY (`Fk_UserId_result`) REFERENCES `User`(`id`);

INSERT INTO Result (Fk_UserId_result, TestBall, TaskBall)
VALUES
	(1,0, 0)
;

SELECT * FROM USER  INNER JOIN  Result ON  USER.id=Result.Fk_UserId_result;

-- -----------------------------------------------------
--
-- -----------------------------------------------------



ALTER TABLE user ADD COLUMN Task1 int null;
ALTER TABLE user ADD COLUMN Task2 int null;
ALTER TABLE user ADD COLUMN Task3 int null;

ALTER TABLE coursetype ADD COLUMN VideoLink varchar(255) null;

update   coursetype set VideoLink="https://www.youtube.com/embed/k1XkZ5ANO64" where Id=1;
"https://www.youtube.com/embed/_J-3nt9bhbI"

ALTER TABLE user MODIFY COLUMN sum  as (Raitung1 + Raitung2+ Raitung3+Task1+Task2+Task3);

--ALTER TABLE user ADD DEFAULT 6 FOR Task3;
--ALTER TABLE user ADD  DEFAULT ('6') FOR Task2;

update   user set Task1=0, Task2=0, Task3=0 where Task2 is null;
update   user set Raitung1=0, Raitung2=0, Raitung3=0 where sum is null;

-- нужно две таблицы: id курсов и айди задач.
--таблица задач
CREATE TABLE IF NOT EXISTS `quizdb`.`task` (
  `TaskId` INT AUTO_INCREMENT PRIMARY KEY,
  `Task` VARCHAR(45) NULL,
  `answer` VARCHAR(45) NULL,
   `idTask` int,
  FOREIGN KEY (idTask) REFERENCES tasktype(id)
);

INSERT INTO task (Task, answer, idTask)
VALUES
	('Задание 2', 'Ответ 2', 1)
;

INSERT INTO task (Task, answer, idTask)
VALUES
	('22task3', '22answer2', 2),
	('33task3', '22answer3', 2)
;

SELECT * FROM tasktype INNER JOIN task ON tasktype.id = task.idTask;

SELECT Name, Description FROM tasktype INNER JOIN task ON tasktype.id = task.idTask;

--create table `quizdb`.`withTask`
--(
--	TaskId int foreign key references dbo.task(TaskId),
--	id int foreign key references dbo.tasktype(Id),
--	primary key(TaskId, Id)
--)

INSERT INTO tasktype (Name, Description, task)
VALUES
	('JSP', 'JavaServer Pages', 'Задача 2'),
	('1', 'Задача', 'Задача 1')
;

ALTER TABLE tasktype  ADD COLUMN task int NULL;
ALTER TABLE tasktype MODIFY COLUMN task VARCHAR(255) ;

USE quizdb;

INSERT INTO user (Name, Email, Password)
VALUES
	('Shawn', 's@s.com', '1234'),
	('Jack', 'j@j.com','4321'),
	('Angelina', 'a@a.com','3281')
;

update coursetype set
INSERT INTO quiztype (Name, Description)
VALUES
	('JSP', 'JavaServer Pages')
;







INSERT INTO coursetype (Name, Description)
VALUES
    ('JSP', 'JavaServer Pages'),
	('курс 2', 'описание курса 2'),
	('курс 3', 'описание курса 3');
update coursetype set Name = 'Рекурсия' where id = 3;
update coursetype set Description = '' where id = 2;

--DROP TABLE COURSETYPE;

--alter table user drop column Raitung;

--INSERT INTO result (Fk_UserId_Result)
--VALUES
--	('1')
--;

ALTER TABLE user ADD COLUMN sum INT as (Raitung1 + Raitung2+ Raitung3);
ALTER TABLE user ADD COLUMN ResTask INT null;

ALTER TABLE tasktype ADD COLUMN answer VARCHAR(255) null;
UPDATE tasktype SET answer='saaa' WHERE id=1;


UPDATE user SET Name='saaa' WHERE id=5;
--UPDATE result SET Fk_UserId_Result='1' WHERE id=1;

UPDATE coursetype SET Theory='theory1' WHERE id=1;
UPDATE coursetype SET Theory='theory2' WHERE id=2;
UPDATE coursetype SET Theory='theory3' WHERE id=3;

UPDATE tasktype SET task='Задача 1' WHERE id=2;


--show columns from result;
--ALTER TABLE feedback MODIFY COLUMN Description VARCHAR(250) ;
--UPDATE quiztype SET ImageURL=(LOAD_FILE('/Uploads/qq.png')) WHERE id=1;


ALTER TABLE coursetype  ADD COLUMN Theory VARCHAR(255) NULL;
--ALTER TABLE user  ADD COLUMN Raitung int NULL;
ALTER TABLE user  ADD COLUMN Raitung1 int NULL;
ALTER TABLE user  ADD COLUMN Raitung2 int NULL;
ALTER TABLE user  ADD COLUMN Raitung3 int NULL;

--UPDATE user SET Raitung=10 WHERE id=1;


--ALTER TABLE quiztype MODIFY COLUMN ImgURL BLOB ;
--

--INSERT INTO theory (theoryId, Description)
--VALUES (1, 'теория'),
--(1, 'теория2');


ALTER TABLE quiztype  ADD COLUMN ImageURL VARCHAR(255) NULL;
--ALTER TABLE quiztype  ADD COLUMN ImgURL VARCHAR(255) NULL;
--UPDATE quiztype SET ImgURL='C:/Program Files/MySQL/MySQL Server 8.0/Upload/qq.png' WHERE id=1;
ALTER TABLE coursetype  modify COLUMN Description MEDIUMTEXT NULL;

INSERT INTO coursetype (Theory)
VALUES ( 'теория');

UPDATE coursetype Set Name='Hibernate' where id=5;
UPDATE coursetype Set  Description='Java Hibernate' where id=5;


--select * from theory;

-- -----------------------------------------------------
--ВОПРОСЫ
-- -----------------------------------------------------



INSERT INTO question (Fk_QuizTypeId_Question, Description)
VALUES
    (1, 'Что называется алгоритмом?'),
    (1, 'Линейным называется алгоритм, если:'),
	(1, 'Цикличным называется алгоритм, если:'),
	(1, 'Алгоритм включает в себя ветвление, если:'),
	(1, 'Что является свойством алгоритма:'),
	(1, 'Cвойство алгоритма, заключающееся в том, что каждое действие и алгоритм в целом должны иметь возможность завершения:'),
	(1, 'Cвойство алгоритма, заключающееся в том, что алгоритм должен состоять из конкретных действий, следующих в определенном порядке:'),
	(1, 'Cвойство алгоритма, заключающееся в том, что один и тот же алгоритм можно использовать с разными исходными данными:'),
	(1, 'Cвойство алгоритма, заключающееся в том, что любое действие должно быть строго и недвусмысленно определено в каждом случае:'),
	(1, 'Алгоритм, записанный на “понятном” компьютеру языке программирования:'),
	(1, 'Для того, чтобы алгоритм бинарного поиска работал правильно нужно, чтобы список был:'),
	(1, 'Необходимо определить максимальное количество узлов в двоичном дереве с высотой k, где корень — нулевая высота:'),
	(1, 'Укажите обозначение следующей фразы: “алгоритм X асимптотически более эффективен, чем Y”:'),
	(1, 'Чем отличается алгоритм обхода графа от алгоритма обхода вершин дерева:'),
	(1, 'Какой из алгоритмов, перечисленных ниже, будет самым производительным, если дан уже отсортированный массив:'),
	(1, 'На чём основан алгоритм Дейкстры:'),
	(1, 'Алгоритм, который не основан на жадном подходе:');


INSERT INTO choice (Fk_QuestionId_Choice, IsAnswer, Description)
VALUES

    (1, 0, 'протокол вычислительной сети'),
	(1, 1, 'описание последовательности действий, строгое исполнение которых приводит к решению поставленной задачи за конечное число шагов'),
	(1, 0, 'правила выполнения определенных действий'),
	(1, 0, 'программный код'),

	(2, 0, 'его команды выполняются в порядке их естественного следования друг за другом независимо от каких-либо условий'),
	(2, 0, 'он включает в себя вспомогательный алгоритм'),
	(2, 0, 'он представим в табличной форме'),
	(2, 0, 'ход его выполнения зависит от истинности тех или иных условий'),

	(3, 0, 'он представим в табличной форме'),
	(3, 0, 'ход его выполнения зависит от истинности тех или иных условий'),
	(3, 1, 'он составлен так, что его выполнение предполагает многократное повторение одних и тех же действий'),
	(3, 0, 'работает один раз'),

	(4, 1, 'ход его выполнения зависит от истинности тех или иных условий'),
	(4, 0, 'он включает в себя вспомогательный алгоритм'),
	(4, 0, 'он представим в табличной форме'),
	(4, 0, 'это дерево'),

	(5, 0, 'цикличность'),
	(5, 0, 'простота записи на языках программирования'),
	(5, 1, 'результативность'),
	(5, 0, 'удобство'),

	(6, 0, 'результативность'),
	(6, 1, 'конечность'),
	(6, 0, 'дискретность'),
	(6, 0, 'удобство'),

	(7, 0, 'массовость'),
	(7, 0, 'детерминированность'),
	(7, 1, 'дискретность'),
	(7, 0, 'двойственность'),

	(8, 0, 'детерминированность'),
	(8, 0, 'дискретность'),
	(8, 0, 'результативность'),
	(8, 1, 'массовость'),

	(9, 1, 'детерминированность'),
	(9, 0, 'дискретность'),
	(9, 0, 'результативность'),
	(9, 1, 'массовость'),

	(10, 0, 'текстовка'),
	(10, 1, 'программа'),
	(10, 0, 'протокол алгоритма'),
	(10, 0, 'речь'),

	(11, 0, 'несортированным'),
	(11, 0, 'выходящим из стека'),
	(11, 1, 'отсортированным'),
	(11, 0, 'пустым'),

	(12, 0, '2ᵏ − 1'),
	(12, 1, '2ᵏ⁺¹ – 1'),
	(12, 0, '2ᵏ⁻¹ + 1'),
	(12, 0, '2ᵏ⁻¹'),

	(13, 0, 'X будет лучшим выбором для всех входов'),
	(13, 0, 'X будет лучшим выбором для всех входов, кроме больших входов'),
	(13, 1, 'X будет лучшим выбором для всех входов, за исключением, возможно, небольших входов'),
	(13, 0, 'Х не будет лучшим выбором'),

	(14, 1, 'графы могут иметь циклы'),
	(14, 0, 'у деревьев есть корни'),
	(14, 0, 'деревья не соединяются'),
	(14, 0, 'деревьев нет в программировании'),

	(15, 0, 'сортировка слиянием'),
	(15, 0, 'пирамидальная сортировка'),
	(15, 1, 'сортировка вставками'),
	(15, 0, 'сортировка массивом'),

	(16, 1, 'на жадном подходе'),
	(16, 0, 'на динамическом программировании'),
	(16, 0, 'на поиске с возвратом'),
	(16, 0, 'на поиске числа'),

	(17, 0, 'алгоритм Хаффмана'),
	(17, 1, 'алгоритм нахождения кратчайшего пути Беллмана-Форда'),
	(17, 0, 'алгоритм Крускала'),
	(17, 0, 'алгоритм Дейкстры');



INSERT INTO quiztype (Name, Description)
VALUES
	('Servlet', 'Java Servlet'),
	('Hibernate', 'Java Hibernate')
;

INSERT INTO question (Fk_QuizTypeId_Question, Description)
VALUES
	(3, 'What’s Hibernate? Find the incorrect statement.'),
	(3, 'What’s the usage of Configuration Interface in hibernate? Find the incorrect statement.')
;

INSERT INTO choice (Fk_QuestionId_Choice, IsAnswer, Description)
VALUES
	(41, 1, 'allows an efficient Object Relational mapping using configuration files in JSON format'),
	(41, 0, 'takes care of the mapping from Java classes to database tables (and from Java data types to SQL data types)');

CREATE TABLE PERSON (
    PERSON_ID SERIAL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

CREATE TABLE CONVERSATION (
    CONVERSATION_ID SERIAL PRIMARY KEY,
    IMPORT_STATUS VARCHAR(50),
    TITLE VARCHAR(255)
);

CREATE TABLE MESSAGE (
    MESSAGE_ID SERIAL PRIMARY KEY,
    PERSON_ID BIGINT,
    CONVERSATION_ID BIGINT,
    CREATED_DATE TIMESTAMP,
    CONTENT TEXT,
    NUMBER_OF_CHARACTERS INT,
    NUMBER_OF_REACTIONS INT,
    FOREIGN KEY (PERSON_ID) REFERENCES PERSON(PERSON_ID),
    FOREIGN KEY (CONVERSATION_ID) REFERENCES CONVERSATION(CONVERSATION_ID)
);

DELETE FROM MESSAGE;
DELETE FROM CONVERSATION;
DELETE FROM PERSON;
COMMIT;


SELECT * FROM MESSAGE;
SELECT * FROM CONVERSATION;
SELECT * FROM PERSON;


SELECT c.title, p.name, m.created_date, m.number_of_reactions, m.content,  FROM MESSAGE m
JOIN CONVERSATION c on c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID
ORDER BY m.NUMBER_OF_CHARACTERS desc;

SELECT  p.name, DATE_PART('Year', created_date) AS year, count(*)  FROM MESSAGE m
JOIN CONVERSATION c on c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID
where c.title = 'Super śmieszne filmiki'
GROUP BY p.name,  DATE_PART('Year', m.created_date);

SELECT
    p.name,
	count(*) as "wszystkie lata",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2017) AS "2017",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2018) AS "2018",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2019) AS "2019",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2020) AS "2020",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2021) AS "2021",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2022) AS "2022",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2023) AS "2023"
FROM MESSAGE m
JOIN CONVERSATION c ON c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p ON p.PERSON_ID = m.PERSON_ID
WHERE c.title = 'Super śmieszne filmiki'
GROUP BY p.name;

SELECT
    p.name,
	count(*) as "wszystkie lata",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2010) AS "2010",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2011) AS "2011",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2012) AS "2012",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2013) AS "2013",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2014) AS "2014",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2015) AS "2015",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2016) AS "2016",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2017) AS "2017",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2018) AS "2018",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2019) AS "2019",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2020) AS "2020",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2021) AS "2021",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2022) AS "2022",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2023) AS "2023"
FROM MESSAGE m
JOIN CONVERSATION c ON c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p ON p.PERSON_ID = m.PERSON_ID
GROUP BY p.name
ORDER BY count(*) desc;

SELECT
DATE_PART('Year', created_date) AS year,
COUNT(*) AS total_employees
FROM MESSAGE m
GROUP BY DATE_PART('Year', m.created_date)
order by year;

SELECT c.title, p.name, m.created_date, m.number_of_reactions, m.content FROM MESSAGE m
JOIN CONVERSATION c on c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID
ORDER BY m.number_of_reactions desc;

SELECT c.title, p.name, m.created_date, m.content FROM MESSAGE m
JOIN CONVERSATION c on c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID
WHERE m.created_date BETWEEN '2015-08-10' AND '2015-11-05'
ORDER BY m.created_date ;

SELECT c.title, p.name, m.created_date, m.content FROM MESSAGE m
JOIN CONVERSATION c on c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID
WHERE c.title = 'imie i nazwisko'
ORDER BY m.created_date ;

SELECT c.title, p.name, m.created_date, m.content FROM MESSAGE m
JOIN CONVERSATION c on c.CONVERSATION_ID = m.CONVERSATION_ID
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID

ORDER BY m.created_date ;

SELECT
    COUNT(*) AS word_count,
		COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2010) AS "2010",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2011) AS "2011",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2012) AS "2012",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2013) AS "2013",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2014) AS "2014",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2015) AS "2015",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2016) AS "2016",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2017) AS "2017",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2018) AS "2018",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2019) AS "2019",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2020) AS "2020",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2021) AS "2021",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2022) AS "2022",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2023) AS "2023"
FROM MESSAGE m
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID
CROSS JOIN regexp_matches(m.content, 'xd', 'gi') AS matches
WHERE p.name = 'imie i nazwisko';


SELECT
p.name,
    COUNT(*) AS word_count,
		COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2010) AS "2010",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2011) AS "2011",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2012) AS "2012",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2013) AS "2013",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2014) AS "2014",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2015) AS "2015",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2016) AS "2016",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2017) AS "2017",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2018) AS "2018",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2019) AS "2019",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2020) AS "2020",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2021) AS "2021",
    COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2022) AS "2022",
	COUNT(*) FILTER (WHERE DATE_PART('Year', m.created_date) = 2023) AS "2023"
FROM MESSAGE m
JOIN PERSON p on p.PERSON_ID = m.PERSON_ID
CROSS JOIN regexp_matches(m.content, 'xD', 'gi') AS matches
group by p.name
order by COUNT(*) desc;

WITH words AS (
    SELECT
        lower(regexp_split_to_table(CONTENT, '\W+')) AS word
    FROM
        MESSAGE
    WHERE
        PERSON_ID = (Select PERSON_ID from PERSON where name = 'imie i nazwisko' )
)
SELECT
    word,
    count(*) AS count
FROM
    words
WHERE
    length(word) > 0
GROUP BY
    word
ORDER BY
    count DESC, word;


WITH words AS (
    SELECT
        lower(regexp_split_to_table(CONTENT, '\W+')) AS word
    FROM
        MESSAGE
    WHERE
        PERSON_ID = (Select PERSON_ID from PERSON where name = 'imie i naziwkso' ) AND
		CONVERSATION_ID = (Select CONVERSATION_ID from CONVERSATION where title = 'imie i naziwko osoby z ktora piszesz' )
)
SELECT
    word,
    count(*) AS count
FROM
    words
WHERE
    length(word) > 0 and word = 'xD'
GROUP BY
    word
ORDER BY
    count DESC, word;


WITH words AS (
    SELECT
        lower(regexp_split_to_table(CONTENT, '\W+')) AS word
    FROM
        MESSAGE
    WHERE
        PERSON_ID = (Select PERSON_ID from PERSON where name = 'imie nazwisko' )
)
SELECT
    word,
    count(*) AS count
FROM
    words
WHERE
    length(word) > 0
GROUP BY
    word
ORDER BY
    count DESC, word;


WITH words AS (
    SELECT
        PERSON_ID,
        lower(regexp_split_to_table(CONTENT, '\W+')) AS word
    FROM
        MESSAGE m
)
SELECT
    p.PERSON_ID,
    p.NAME,
    count(*) AS "kurwa"
FROM
    words w
JOIN
    PERSON p ON w.PERSON_ID = p.PERSON_ID
WHERE
    w.word = 'kurwa'
GROUP BY
    p.PERSON_ID,
    p.NAME
ORDER BY
    "kurwa" DESC, p.NAME;


WITH WordsCTE AS (
    SELECT
        PERSON_ID,
        lower(regexp_split_to_table(CONTENT, '\W+')) AS word
    FROM
        MESSAGE
),
DomCount AS (
    SELECT
        PERSON_ID,
        count(*) AS dom_count
    FROM
        WordsCTE
    WHERE
        word = 'xd'
    GROUP BY
        PERSON_ID
),
TotalWords AS (
    SELECT
        PERSON_ID,
        count(*) AS total_words
    FROM
        WordsCTE
    GROUP BY
        PERSON_ID
)

SELECT
    p.PERSON_ID,
    p.NAME,
    COALESCE(d.dom_count, 0) AS "Number of 'xd'",
    t.total_words AS "Total words",
    (COALESCE(d.dom_count, 0) * 100.0 / t.total_words) AS "Percentage of 'xd'"
FROM
    PERSON p
LEFT JOIN
    DomCount d ON p.PERSON_ID = d.PERSON_ID
JOIN
    TotalWords t ON p.PERSON_ID = t.PERSON_ID
ORDER BY
    "Percentage of 'xd'" DESC, p.NAME;

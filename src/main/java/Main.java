/*
    10 variant: 1   1   0   1   110    0   1   0

    5. Клиентский интерфейс доступа к БД: 1 — через консоль клиента (консольное приложение).
    6. Обеспечить сброс значений всех не ключевых полей на основе данных записанных в: 1 — файле.
    7. Вывод всех значений указанного поля (не «ключа») (см. П.8) указанной таблицы в
    лексикографическом порядке (на консоль, либо в текстовое поле, либо другой
    удобный для вас графический компонент): 0 — первой.
    8. Поле по порядку таблицы указанной в П.7: 1 — второе.
    10. Учебные аудитории (табл.1: {«уникальный ключ», учебное здание, номер аудит.,
    наименование, площадь}, табл.2: {«уникальный ключ», ФИО ответственного,
    должность, телефон, возраст});
    (ё : 110) вывести список самых младших сотрудников (ФИО, должность, телефон,
    возраст) в лексикографическом порядке, найти общую площадь аудиторий
    закреплённых за указанным ответственным;
    11. Вывод всех значений указанного поля (не «ключа») (см. П.12) указанной таблицы в
    лексикографическом порядке (на консоль, либо в текстовое поле, либо другой
    удобный для вас графический компонент): 0 — первой, 1 — второй.
    12. Поле по порядку таблицы указанной в П.11: 0 — второе.
    14. Ваше фактическое задание выполнять применительно к БД: 0 — «Учебные
    аудитории».
    15. Выбор записи для удаления или изменения по: 1 — по
    уникальному ключу (можно посмотреть в IDE NetBeans).
     */

import service.ConsoleUI;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}

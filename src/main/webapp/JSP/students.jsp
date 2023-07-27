<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/styles/student_list.css">
</head>
<body>
<div class="container">
    <div class="main-block">
        <div class="title">
            <h1>Система управления студентами и их успеваемостью</h1>
        </div>
        <div class="flex-link">
            <div class="buttons-1">
                <button class="flex-buttons-1">Посмотреть успеваемость выбранных студентов</button>
                <button class="flex-buttons-1">Модифицировать выбранного студента</button>
            </div>
            <div  class="buttons-2">
                <button class="flex-buttons-2">Создать Студента...</button>
                <button class="flex-buttons-2">Удалить выбранных студентов</button>
            </div>
        </div>
        <div>
            <h2 class="student-list">Cписок студентов</h1>
        </div>
        <div>
            <table>
                <tr>
                    <th></th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Группа</th>
                    <th>Дата поступления</th>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>Cидоров</td>
                    <td>Cидор</td>
                    <td>КТ-21</td>
                    <td>20.09.2011</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>
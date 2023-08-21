<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modify Student</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/styles/student_modifying.css">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg bg-body-tertiary navbar-border main-block">
        <div class="container-fluid">
            <div class="col-sm-10">
                <h1>Система управления студентами и их успеваемостью</h1>
            </div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse col-sm-2" id="navbarNavDropdown">
                <ul class="navbar-nav test-flex">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle page-actions system-item" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Система
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item system-item" href="/title">Главная</a></li>
                            <li><a class="dropdown-item system-item" href="#">Войти в Уч. Запись</a></li>
                            <li><a class="dropdown-item system-item" href="#">Регистрация</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="intro-text">
        <h3>Для модификации студента введите новые значения и нажмите кнопку "Применить"</h3>
    </div>
    <form action="/student_modify" method="post">
        <div>
            <table>
                <tr>
                    <td>Фамилия</td>
                    <td><input type="text" name="surname" value="${student.surname}" required></td>
                </tr>
                <tr>
                    <td>Имя</td>
                    <td><input type="text" name="name" value="${student.name}" required></td>
                </tr>
                <tr>
                    <td>Группа</td>
                    <td><input type="text" name="group" value="${student.group}" required></td>
                </tr>
                <tr>
                    <td>Дата поступления</td>
                    <td><input type="text" id="datepicker" name="date" value="${student.date_in}" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="create-button">
                        <button class="create">Применить</button>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="outro-text">
        <h4><i>Поля не должны быть пустыми!</i></h4>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
    $( function() {
        $( "#datepicker" ).datepicker({
            showButtonPanel: true
        });
    } );
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>


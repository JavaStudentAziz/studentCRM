<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../resources/styles/title_page.css">
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
    <div class="flex-link">
        <a href="/students" class="three-musketeers">Студенты</a>
        <a href="/disciplines" class="three-musketeers">Дисциплины</a>
        <a href="terms_list.html" class="three-musketeers">Семестры</a>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>
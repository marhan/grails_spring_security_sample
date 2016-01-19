<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body role="document">

<div class="container">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="page-header">
        <h2>Login</h2>
    </div>

    <g:if test='${flash.message}'>
        <div class="alert alert-warning" role="alert">
            <strong>Warning!</strong> ${flash.message}
        </div>
    </g:if>


    <sec:ifNotLoggedIn>
        <div class="alert alert-info" role="alert">
            <strong>Info</strong> Please login to proceed
        </div>
    </sec:ifNotLoggedIn>



    <form action='${postUrl}' method='POST' id='loginForm' autocomplete='off'>

        <div class="col-md-4">

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text"
                       class="form-control"
                       placeholder="Username"
                       aria-describedby="basic-addon1"
                       name="username"
                       id="username">

            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password"
                       class="form-control"
                       placeholder="Password"
                       aria-describedby="basic-addon1"
                       name="password"
                       id="password">

            </div>

            <div class="form-group">
                <div clas="row">
                    <span class="input-group-lg">
                        <input type="checkbox"
                               name='${rememberMeParameter}'
                               <g:if test='${hasCookie}'>checked='checked'</g:if>
                               id="remember_me">
                    </span>
                    <label for="remember_me">Remember me</label>
                </div>
            </div>

            <button class="btn btn-primary" type="submit">Log in</button>

        </div>

    </form>

</div>
</body>
</html>


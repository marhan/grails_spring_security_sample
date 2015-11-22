<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body role="document">

<div class="container">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="page-header">
        <h2>Edit User Data</h2>
    </div>

    <g:form controller="user" action="update" method='POST'>

        <div class="col-md-4">

            <g:hasErrors>
                <div class="alert alert-warning" role="alert">
                    Please review the input
                </div>
            </g:hasErrors>


            <input type="hidden" formmethod="post" name="id" value="${user?.id}">

            <div class="form-group <g:hasErrors bean="${user}" field="username">has-error</g:hasErrors>">

                <label for="username">Username</label>

                <input type="text"
                       class="form-control"
                       placeholder="Username"
                       aria-describedby="basic-addon1"
                       name="username"
                       value="${user?.username}"
                       id="username">

                <g:hasErrors bean="${user}" field="username">
                    <div class="alert alert-danger" role="alert">
                        <g:fieldError bean="${user}" field="username"/>
                    </div>
                </g:hasErrors>

            </div>


            <div class="form-group <g:hasErrors bean="${user}" field="email">has-error</g:hasErrors>">

                <label for="email">Username</label>

                <input type="text"
                       class="form-control"
                       placeholder="Email"
                       aria-describedby="basic-addon1"
                       name="email"
                       value="${user?.email}"
                       id="email">

                <g:hasErrors bean="${user}" field="email">
                    <div class="alert alert-danger" role="alert">
                        <g:fieldError bean="${user}" field="email"/>
                    </div>
                </g:hasErrors>

            </div>


            <div class="form-group <g:hasErrors bean="${user}" field="password">has-error</g:hasErrors>">

                <label for="password">Password</label>

                <input type="password"
                       class="form-control"
                       placeholder="Password"
                       aria-describedby="basic-addon1"
                       name="password"
                       id="password">

                <g:hasErrors bean="${user}" field="password">
                    <div class="alert alert-danger" role="alert">
                        <g:fieldError bean="${user}" field="password"/>
                    </div>
                </g:hasErrors>

            </div>

            <div class="form-group <g:hasErrors bean="${user}" field="password">has-error</g:hasErrors>">

                <label for="passwordRepeat">Password Repeat</label>

                <input type="password"
                       class="form-control"
                       placeholder="Password"
                       aria-describedby="basic-addon1"
                       name="passwordRepeat"
                       id="passwordRepeat">

                <g:hasErrors bean="${user}" field="passwordRepeat">
                    <div class="alert alert-danger" role="alert">
                        <g:fieldError bean="${user}" field="passwordRepeat"/>
                    </div>
                </g:hasErrors>

            </div>

            <button class="btn btn-primary" type="submit">Save changes</button>
        </div>

    </g:form>

</div>
</body>
</html>


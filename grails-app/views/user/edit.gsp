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

    <form action='${postUrl}' method='POST'>

        <div class="col-md-4">

            <input type="hidden" formmethod="post" name="id" value="${user?.id}">

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text"
                       class="form-control"
                       placeholder="Username"
                       aria-describedby="basic-addon1"
                       name="username"
                       value="${user?.username}"
                       id="username">

            </div>

            <div class="form-group">
                <label for="email">Username</label>
                <input type="text"
                       class="form-control"
                       placeholder="Email"
                       aria-describedby="basic-addon1"
                       name="email"
                       value="${user?.email}"
                       id="email">

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

            <button class="btn btn-primary" type="submit">Update</button>

        </div>

    </form>

</div>
</body>
</html>


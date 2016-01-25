<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body role="document">

<div class="container theme-showcase" role="main">

    <div class="jumbotron">
        <h2><a href="https://grails.org/">Grails 3</a> sample project with
            <a href="http://grails-plugins.github.io/grails-spring-security-core/v3/index.html">
                Spring Security Core Plugin V3
            </a>
        </h2>
    </div>


    <div class="row">
        <div class="col-md-6">
            <table class="table table-striped table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td><g:link controller="user" action="edit" id="1">admin</g:link></td>
                    <td>password</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td><g:link controller="user" action="edit" id="2">user</g:link></td>
                    <td>password</td>
                </tr>
                </tbody>
            </table>
        </div>


        <div class="col-md-6">
            <table class="table table-striped table table-bordered">
                <thead>
                <tr>
                    <th>Your security property</th>
                    <th>Value</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Logged in</td>
                    <td>
                        <sec:ifLoggedIn>
                            <span class="label label-success">true</span>
                        </sec:ifLoggedIn>
                        <sec:ifNotLoggedIn>
                            <span class="label label-warning">false</span>
                        </sec:ifNotLoggedIn>
                    </td>
                </tr>
                <tr>
                    <td>Switched</td>
                    <td>
                        <sec:ifSwitched>
                            <span class="label label-info">
                                true
                            </span>
                        </sec:ifSwitched>
                        <sec:ifNotSwitched>
                            <span class="label label-warning">
                                false
                            </span>
                        </sec:ifNotSwitched>
                    </span>
                    </td>
                </tr>
                <tr>
                    <td>Principal Enabled</td>
                    <td>
                        <sec:ifNotLoggedIn>
                            <span class="fa-stack fa">
                                <i class="fa-ban fa text-danger"></i>
                            </span>
                        </sec:ifNotLoggedIn>
                        <sec:ifLoggedIn>
                            <span class="label label-info">
                                <sec:loggedInUserInfo field="enabled"/>
                            </span>
                        </sec:ifLoggedIn>
                    </td>
                </tr>
                <tr>
                    <td>Granted roles</td>
                    <td>
                        <sec:ifNotLoggedIn>
                            <span class="fa-stack fa">
                                <i class="fa-ban fa text-danger"></i>
                            </span>
                        </sec:ifNotLoggedIn>
                        <sec:access expression="hasRole('ROLE_USER')">
                            <span class="label label-info">You are a user</span>
                        </sec:access>
                        <sec:access expression="hasRole('ROLE_ADMIN')">
                            <span class="label label-info">You are an admin</span>
                        </sec:access>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <table class="table table-striped table table-bordered">
                <thead>
                <tr>
                    <th>Access</th>
                    <th>State</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>You are authenticated</td>
                    <td>
                        <sec:access expression="isAuthenticated()">
                            <span class="label label-info">true</span
                        </sec:access>
                        <sec:noAccess expression="isAuthenticated()">
                            <span class="label label-warning">false</span
                        </sec:noAccess>
                    </td>
                </tr>
                <tr>
                    <td>You are fully authenticated</td>
                    <td>
                        <sec:access expression="isFullyAuthenticated()">
                            <span class="label label-info">true</span
                        </sec:access>
                        <sec:noAccess expression="isFullyAuthenticated()">
                            <span class="label label-warning">false</span
                        </sec:noAccess>
                    </td>
                </tr>
                <tr>
                    <td>You are anonymous</td>
                    <td>
                        <sec:access expression="isAnonymous()">
                            <span class="label label-info">true</span
                        </sec:access>
                        <sec:noAccess expression="isAnonymous()">
                            <span class="label label-warning">false</span
                        </sec:noAccess>
                    </td>
                </tr>
                <tr>
                    <td>You are remembered</td>
                    <td>
                        <sec:access expression="isRememberMe()">
                            <span class="label label-info">true</span
                        </sec:access>
                        <sec:noAccess expression="isRememberMe()">
                            <span class="label label-warning">false</span
                        </sec:noAccess>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>


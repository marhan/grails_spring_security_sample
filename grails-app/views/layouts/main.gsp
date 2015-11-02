<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><g:layoutTitle default="Grails Security Sample"/></title>
    <asset:stylesheet src="bootstrap-all.css"/>
    <asset:stylesheet src="font-awesome-less.css"/>
    <asset:javascript src="jquery.js"/>
    <asset:javascript src="bootstrap-all.js"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <g:layoutHead/>
</head>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Security Sample</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Secured Pages<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Login based security</li>
                        <li><g:link controller="fullAuthenticated">Full authenticated only</g:link></li>
                        <li><g:link controller="rememberedAuthenticated">Remember me sufficient</g:link></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Role based security</li>
                        <li><a href="#">Admin role only</a></li>
                        <li><a href="#">User role only</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <sec:ifLoggedIn>
                    <li><g:link controller="user"
                                action="edit"
                                id="${sec.loggedInUserInfo(field:'id')}">Logged in as <sec:username /></g:link></li>

                    <li><g:link controller="logout">Logout</g:link></li>
                </sec:ifLoggedIn>

                <sec:ifNotLoggedIn>
                    <li><g:link controller="login" action='auth'>Login</g:link></li>
                </sec:ifNotLoggedIn>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<body role="document">

<g:layoutBody/>

</body>

</html>

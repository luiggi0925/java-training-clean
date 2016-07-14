<!doctype html>
<html>
<head>
	<title>Attribute Scope example</title>
	<meta charset="UFT-8">
</head>
<body>
	<h2>Application context counter value: ${applicationScope.counter}</h2>
	<br />
	<h2>Application context counter value: ${sessionScope.counter}</h2>
	<br />
	<h2>Application context counter value: ${requestScope.counter}</h2>
	<br />
	<h2>Application context counter value: ${counter}</h2>
	<br />
</body>
</html>

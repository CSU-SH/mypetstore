<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

<form action="signon" method="post">
	<p>Please enter your username and password.</p>
	<p>
		Username:<input type="text" name="username" value="j2ee" /> <br />
	    Password:<input type="password" name="password" value="j2ee" /><br />
		VerificationCode:<input type="text" name="vCode" size="5" maxlength="4"/>
		 <img border="0" src="verificationCode" name="checkcode"><a href="signonForm">switch to another captcha</a>
	</p>
	<input type="submit" name="signon" value="Login" />

	<p>Need a user name and password?</p>
	<a href="newAccountForm">
		Register Now!
	</a>
</form>
	</div>

<%@ include file="../common/IncludeBottom.jsp"%>
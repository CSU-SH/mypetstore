<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="shippingAddress" method="post">

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text" name="firstName" value="${sessionScope.order.shipToFirstName}"/></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="lastName" value="${sessionScope.order.shipToLastName}"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" size="40" name="address1" value="${sessionScope.order.shipAddress1}"/></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" size="40" name="address2" value="${sessionScope.order.shipAddress2}"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="city" value="${sessionScope.order.shipCity}"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" size="4" name="state" value="${sessionScope.order.shipState}"/></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" size="10" name="zip" value="${sessionScope.order.shipZip}"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" size="15" name="country" value="${sessionScope.order.shipCountry}"/></td>
		</tr>


	</table>

	<input type="submit" name="newOrder" value="Continue" />

	</form></div>

<%@ include file="../common/IncludeBottom.jsp"%>
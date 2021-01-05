<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="confirmOrderForm" method="post">

	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>
				<select name="order.cardType">
					<option value="${sessionScope.order.cardType}">
						${sessionScope.order.cardType}
					</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><input type="text" name="order.creditCard" value="${sessionScope.order.creditCard}"/> * Use a fake
			number!</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><input type="text" name="order.expiryDate" value="${sessionScope.order.expiryDate}"/></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<td>First name:</td>
		<td><input type="text" name="firstName" value="${sessionScope.order.billToFirstName}"/></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="lastName" value="${sessionScope.order.billToLastName}"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" size="40" name="address1" value="${sessionScope.order.billAddress1}"/></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" size="40" name="address2" value="${sessionScope.order.billAddress2}"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="city" value="${sessionScope.order.billCity}"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" size="4" name="state" value="${sessionScope.order.billState}"/></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" size="10" name="zip" value="${sessionScope.order.billZip}"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" size="15" name="country" value="${sessionScope.order.billCountry}"/></td>
		</tr>

		<tr>
			<td colspan=2>
			<a href="shippingForm"> Ship to different address...</a>
			</td>
		</tr>

	</table>

	<input type="submit" name="newOrder" value="Continue" />

	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
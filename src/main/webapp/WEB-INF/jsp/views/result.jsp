<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br/>


<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>Result</th>
			<th>Time Taken(ms)</th>
			<th>Position Changes</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="result">
			<tr>
				<td>${result.result}</td>
				<td>${result.timeTaken}</td>
				<td>${result.positionChanges}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

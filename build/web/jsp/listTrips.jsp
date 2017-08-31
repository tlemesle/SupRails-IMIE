<%-- 
    Document   : listTrips
    Created on : Jan 6, 2012, 7:42:11 PM
    Author     :  
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Trips</title>
        <style>
            table {
                width: 80%; 
                margin: auto;
                border-collapse: collapse;
            }
            
            table tr td, table tr th {
                text-align: center;
                border: 1px solid black;
            }
            
            form{
                text-align: center;
                margin-bottom: 3px;
            }
        </style>
    </head>
    <body>
        <form method="POST">
                <label for="departure">Departure station:</label>
                <select id="departure" name="departure">
                    <c:forEach items="${stations}" var="station">
                        <option value="${station.id}">
                            <c:out value="${station.name} (${station.city})"/>
                        </option>
                    </c:forEach>
                </select>
                <label for="arrival">Arrival station:</label>
                <select id="arrival" name="arrival">
                    <c:forEach items="${stations}" var="station">
                        <option value="${station.id}">
                            <c:out value="${station.name} (${station.city})"/>
                        </option>
                    </c:forEach>
                </select>

                <label for="price">Price:</label>
                <input type="text" id="price" name="price" required/>
                <input type="submit" value="Filter" />
        </form>
        <c:choose>
            <c:when test="${not empty trips}">
                <table>
                    <tr>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Price</th>
                        <th>Action n°1</th>
                        <c:if test="${not empty user}">
                        <th>Action n°2</th>
                        </c:if>
                    </tr>
                    <tr>
                        <c:forEach items="${trips}" var="trip">

                            <c:url value="/admin/trips/delete" var="deleteTripUrl">
                                <c:param name="id" value="${trip.id}" />
                            </c:url>

                            <c:url value="/trips/buy" var="buyTripUrl">
                                <c:param name="id" value="${trip.id}" />
                            </c:url>
                            <td><c:out value="${trip.departureStation.name}" /></td>
                            <td><c:out value="${trip.arrivalStation.name}" /></td>
                            <td><c:out value="€${trip.price}" /></td>
                            <c:if test="${not empty user}">
                                <td>
                                    <a href="${deleteTripUrl}">Delete</a>
                                </td>
                                <td>
                                    <a href="${buyTripUrl}">Buy</a>
                                </td>
                            </c:if>
                            <c:if test="${empty user}">                                <td>
                                    <a href="${buyTripUrl}">Buy</a>
                                </td></c:if>
                    </tr>

                        </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>No Trips in Database.</p>
            </c:otherwise>
        </c:choose>
        
        <c:if test="${not empty user}">
            <c:url value="/admin/trips/add" var="addTripUrl" />
            <a href="${addTripUrl}">Add a new trip</a>
        </c:if>
    </body>
</html>

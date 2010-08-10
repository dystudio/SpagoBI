<%@ page session="true" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://www.tonbeller.com/jpivot" prefix="jp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>



<jp:mondrianQuery id="query01" jdbcDriver="com.mysql.jdbc.Driver" jdbcUrl="jdbc:mysql://localhost/foodmartmondrian?user=root&password="catalogUri="/WEB-INF/schema/FoodMart.xml">
with member [Measures].[ROI] as '(([Measures].[Store Sales] - [Measures].[Store Cost]) / [Measures].[Store Cost])', format_string = IIf((((([Measures].[Store Sales] - [Measures].[Store Cost]) / [Measures].[Store Cost]) * 100.0) > 150.0), "|#.00%|arrow='up'", IIf((((([Measures].[Store Sales] - [Measures].[Store Cost]) / [Measures].[Store Cost]) * 100.0) < 150.0), "|#.00%|arrow='down'", "|#.00%|arrow='none'"))
select {[Measures].[ROI], [Measures].[Store Cost], [Measures].[Store Sales]} ON columns,
  {[Product].[All Products]} ON rows
from [Sales]
where [Time].[1997]
</jp:mondrianQuery>

<c:set var="title01" scope="session">Arrows</c:set>

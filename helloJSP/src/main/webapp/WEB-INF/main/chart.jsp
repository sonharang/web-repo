<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      
    	google.charts.load("current", {packages:["corechart"]});
     	google.charts.setOnLoadCallback(drawChart);
      
      function drawChart() {
     	fetch('drawChart.do')
     		.then(resolve=>resolve.json())
     		.then(result=>{
     			console.log(result);
     			let dataAry = [["writer","cnt"]];
     			result.forEach(item =>{
     				dataAry.push([item.REPLYER, item.CNT])
     			})
     			// [['writer', 'cnt'],['M001,12'],['M002,22'],['M003,32']]
     			console.log(dataAry);
     			var data = google.visualization.arrayToDataTable(dataAry);
     	        var options = {
     	          title: '작성자 건수별',
     	          is3D: true,
     	        };

     	        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
     	        chart.draw(data, options);
     		})
     		.catch(err => console.log(err));
     		
    	 
      }
    
      </script>

<div id="piechart_3d" style="width: 900px; height: 500px;"></div>

<jsp:include page="../layout/footer.jsp"></jsp:include>
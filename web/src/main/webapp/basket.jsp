<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 체크</title>
</head>
<body>
<form id="frm" method="post" action="./paylist.do">
<p>장바구니</p>
<input type="checkbox" name="p" id="p1" value="399000" data-name="프리즘코리아 CP55G5" onclick="price()">프리즘코리아 CP55G5 	 399900<br>
<input type="checkbox" name="p" id="p2" value="2192810" data-name="삼성전자 QLED KQ85" onclick="price()">삼성전자 QLED KQ85 	 2192810<br>
<input type="checkbox" name="p" id="p3" value="2732230" data-name="LG전자 올레드 evo" onclick="price()">LG전자 올레드 evo  	2732230<br>
<input type="checkbox" name="p" id="p4" value="359000" data-name="이스트라 스마트 TV" onclick="price()">이스트라 스마트 TV 	 359000<br>
<input type="checkbox" name="p" id="p5" value="790000" data-name="LG전자 울트라 HD" onclick="price()">LG전자 울트라 HD 	 790000<br>

<p>최종 결제금액: <input type="text" name="total" id ="total" value="0" readonly> <p>

<!-- 선택된 상품 정보 저장할 hidden input -->
    <input type="hidden" name="selectedProducts" id="selectedProducts">
    
<br>
<input type="button" value="결제하기" onclick="pay()">
</form>
</body>
<script>

//https://com0748.tistory.com/22
function price(){
	
	//var total = parseInt(document.getElementById("total").value);
	/*체크 시 값이 넣어지지만, 체크를 해지해도 0원이 되지 않고, 다시 체크시 가격이 합산되기만 함
	-> 처음에는 기존 total value값인 0을 가져오지만, 그 이후에는 값이 합산된체 누적되어 계속 체크된 항목만 더해지게 됨
	따라서 매번 total을 0으로 초기화시켜 계산해야 함*/
	
	var total = 0;
	var selectedProducts = [];
	
	for(var a=1; a<6; a++){
		var check = document.getElementById("p" + a);
		if(check.checked){
			total += parseInt(check.value);
			selectedProducts.push(check.getAttribute("data-name") + " - " + check.value + "원");
        }
	}
		document.getElementById("total").value = total;
		document.getElementById("selectedProducts").value = selectedProducts.join(", "); // 상품명과 가격을 문자열로 저장
	
		// 콘솔에 출력 (디버깅 용)
	    console.log("Total Price: " + total);
	    console.log("Selected Products: " + selectedProducts.join(", "));
}



/*	var arr = frm.p;
	var al = arr.length;
	//console.log(al); //5
	
	var arr2 = new Array();
	
	for(var a=0; a<arr.length; a++){
		if(arr[a].checked == true){
			var ch = arr[a].id.replace('p', 'value');
			var price = document.getElementById(ch).innerText;
			arr2.push(price);
		}
	}

	var total = 0;
	
	for(var a=0; a<arr2.length; a++){
		total += parseInt(arr2[a]);
	}

	document.getElementById('value').innerText = total;
	console.log(total);
}*/


function pay(){
		frm.submit();
}

</script>
</html>
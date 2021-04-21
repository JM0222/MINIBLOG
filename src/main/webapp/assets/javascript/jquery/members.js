function checkForm(frm) {
	console.log(frm);
	
	var name = frm.userName.value.trim();
	var id = frm.id.value.trim();
	var password = frm.password.value.trim();
	var check = frm.check.value;	//	중복 이메일 체크 여부
	
	//	TODO: 추가 검증
	if (name.length < 3) {
		alert("이름은 3자리 이상의 문자입니다.");
		frm.name.focus();
	} else if (password.length < 4) {
		alert("비밀번호는 4자리 이상이어야 합니다.");
		frm.password.focus();
	} else if (id.length < 3) {
		alert("이메일은 3자리 이상으로 입력해 주세요.");
		frm.email.focus();
	} else if (check != "t") {	//	중복 체크 안함
		alert("이메일 중복 체크를 해 주십시오.");
	} else {	//	검증 통과
		return true;	//	폼 전송
	}
	
	return false;	//	onsubmit 이벤트에서 true여야 전송
}

function checkid(idField, url) {

	
	//	Ajax 호출
	if (idField.value.trim().length == 0) {
		alert("아이디를 입력해 주세요");
		return;
	}
	$.ajax({
		url: url,
		type: "GET",
		dataType: "json",
		data: {
			id: idField.value.trim()
		}, 
		success: function(result) {
			console.log("Result:", result);
			//	hidden field: check 값을 변경
			if (result.data == true) {	//	중복 이메일
				idField.form.check.value = "f";
				alert("이미 가입된 이메일입니다");
			} else {
				idField.form.check.value = "t";
				alert("가입하실 수 있는 이메일입니다");
			}
		},
		error: function(xhr, status, error) {
			console.error("Status:", status);
			console.error("Response:", xhr);
			console.error("Error:", error);
			
			idField.form.check.value = "f";
		}		
	});
}